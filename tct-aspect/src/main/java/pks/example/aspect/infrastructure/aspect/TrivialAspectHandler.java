package pks.example.aspect.infrastructure.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TrivialAspectHandler {

	@Around(value = "execution( * pks.example.aspect.core.*.get*(..))")
	public void check(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("trivial domain object get*() method check");
		joinPoint.proceed();
	}
}
