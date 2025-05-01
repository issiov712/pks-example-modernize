package pks.example.modernize.aspect.audit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import javax.money.format.AmountFormatQueryBuilder;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.javamoney.moneta.Money;

import org.slf4j.Logger;


@Aspect
public class DomainAuditingAspect {

	@Before(value = "set(org.javamoney.moneta.Money pks.example.modernize.domain..*) && args(money)")
	public void auditSetMoneyType(final Money money, JoinPoint joinPoint) throws Throwable {

		Logger log = DomainLoggingCache.getJoinPointLogger(joinPoint);
		log.debug(joinPoint.getSignature().toString() + " : " + ( money != null ? money.toString() : "null " ));
		// Object[] result = { (Object)money };
		// joinPoint.proceed(result);
	}

	@Before(value = "call(pks.example.modernize.domain..new(..))")
	public void auditConstructorCall(JoinPoint joinPoint) throws Throwable {

		Logger log = DomainLoggingCache.getJoinPointLogger(joinPoint);
		log.debug(joinPoint.getArgs().toString());
	}

	@Before(value = "call(* pks.example.modernize.domain..build())")
	public void auditBuildCall(JoinPoint joinPoint) throws Throwable {

		Logger log = DomainLoggingCache.getJoinPointLogger(joinPoint);
		log.debug(joinPoint.getArgs().toString());
	}
}
