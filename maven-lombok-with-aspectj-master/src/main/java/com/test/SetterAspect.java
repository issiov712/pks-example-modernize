package com.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import javax.money.format.AmountFormatQueryBuilder;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class SetterAspect {

	// How-to: https://peterdev.pl/2020/02/07/formatting-monetary-amounts-with-java-money/
	MonetaryAmountFormat formatUSD = MonetaryFormats.getAmountFormat(
		AmountFormatQueryBuilder.of(Locale.US)
			.set(CurrencyStyle.SYMBOL)
			.build());

	ConcurrentHashMap<String,Logger> clazzLoggers = new ConcurrentHashMap<>();

	Logger getJoinPointLogger(ProceedingJoinPoint joinPoint) {
		String clazzName = joinPoint.getSignature().getDeclaringTypeName();
		//String clazzName = joinPoint.getTarget().getClass().getName();
		Logger logger = clazzLoggers.get(clazzName);
		if (logger == null) { 
			logger = LoggerFactory.getLogger(clazzName);
			clazzLoggers.put(clazzName,logger);
		}
		return logger;
	}


    @Around(value = "execution(* com.test.entity.*.set*(..))")
    public void checkBeforeCallingSetter(ProceedingJoinPoint joinPoint) throws Throwable {

		Logger log = getJoinPointLogger(joinPoint);

        Object valueToBeSet = joinPoint.getArgs()[0];

        if (valueToBeSet != null && isNotEmpty(valueToBeSet)) {
            log.info("proceeding");
            joinPoint.proceed();
        }
        
        System.out.println("not proceeding");
    }

    private boolean isNotEmpty(Object valueToBeSet) {
        if (valueToBeSet instanceof String) {
            return !"".equals(valueToBeSet);
        } else {
            return true;
        }
    }

	@Around(value = "execution(* com.test..build(..))")
	public Object checkXferObjects(ProceedingJoinPoint joinPoint) throws Throwable {

		Logger log = getJoinPointLogger(joinPoint);

		Object obj = joinPoint.proceed();
		log.info("build: " + obj.getClass());

		return obj;
	}

	@Around(value = "set(org.javamoney.moneta.Money com.test.entity..*)")
	public void checkMoney(ProceedingJoinPoint joinPoint) throws Throwable {

		Logger log = getJoinPointLogger(joinPoint);

		Money m = (Money)joinPoint.getArgs()[0];
		String msg = "thieving a money slice off the top from '" + formatUSD.format(m);
		m = m.multiply(0.99d);
		msg = msg + "' to '" + formatUSD.format(m) + "'";
		log.warn(msg);

		Object[] r = { (Object)m };
		joinPoint.proceed(r);
	}
}
