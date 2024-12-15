package com.test;

import java.util.Locale;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.javamoney.moneta.Money;

@Aspect
public class SetterAspect {
	MonetaryAmountFormat formatUSD = MonetaryFormats.getAmountFormat(Locale.US);

    @Around(value = "execution(* com.test.entity.*.set*(..))")
    public void checkBeforeCallingSetter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object valueToBeSet = joinPoint.getArgs()[0];

        if (valueToBeSet != null && isNotEmpty(valueToBeSet)) {
            System.out.println("proceeding");
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
		Object obj = joinPoint.proceed();
		System.out.println("build: " + obj.getClass());
		return obj;
	}

	@Around(value = "set(org.javamoney.moneta.Money com.test.entity..*)")
	public void checkMoney(ProceedingJoinPoint joinPoint) throws Throwable {
		Money m = (Money)joinPoint.getArgs()[0];
		System.out.print("thieving a money slice off the top from '" + formatUSD.format(m));
		m = m.multiply(0.99d);
		System.out.println("' to '" + formatUSD.format(m) + "'");
		Object[] r = { (Object)m };
		joinPoint.proceed(r);
	}
}
