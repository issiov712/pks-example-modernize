package pks.example.ddd.infrastructure.aspect;
/*
import java.util.Arrays;
import java.util.Enumeration;

// import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;

@Aspect
// @Component
public class LoggingHandler {

 Logger log = LoggerFactory.getLogger(this.getClass());

//  @Pointcut("within(@org.springframework.stereotype.Controller *)")
//  public void controller() {
//  }

 @Pointcut("execution(* *.*(..) && !execution(* *.toString(..)))")
 protected void allMethod() {
 }

 @Pointcut("execution(public * *(..))")
 protected void loggingPublicOperation() {
 }

 @Pointcut("execution(* *.*(..))")
 protected void loggingAllOperation() {
 }

 @Pointcut("within(pks.example.ddd.core..*)")
 private void logAnyFunctionWithinResource() {
 }

 @Pointcut("!within(pks.example.ddd.infrastructure.aspect..*)")
 private void nonCircular() {
 }

 //before -&gt; Any resource annotated with @Controller annotation 
 //and all method and function taking HttpServletRequest as first parameter
//  @Before("controller() &amp;&amp; allMethod() &amp;&amp; args(..,request)")
 @Before("nonCircular() && logAnyFunctionWithinResource() && allMethod() && args(..)")
 public void logBefore(JoinPoint joinPoint) { // }, HttpServletRequest request) {

  System.out.println("Entering in Method :  " + joinPoint.getSignature().getName());
  log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
  log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
  log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
  log.debug("Target class : " + joinPoint.getTarget().getClass().getName());

  // if (null != request) {
  //  log.debug("Start Header Section of request ");
  //  log.debug("Method Type : " + request.getMethod());
  //  Enumeration headerNames = request.getHeaderNames();
  //  while (headerNames.hasMoreElements()) {
  //   String headerName = headerNames.nextElement();
  //   String headerValue = request.getHeader(headerName);
  //   log.debug("Header Name: " + headerName + " Header Value : " + headerValue);
  //  }
  //  log.debug("Request Path info :" + request.getServletPath());
  //  log.debug("End Header Section of request ");
  // }
 }
 //After -&gt; All method within resource annotated with @Controller annotation 
 // and return a  value
//  @AfterReturning(pointcut = "controller() &amp;&amp; allMethod()", returning = "result")
 @AfterReturning(pointcut = "nonCircular() && logAnyFunctionWithinResource() && allMethod()", returning = "result")
 public void logAfter(JoinPoint joinPoint, Object result) {
  String returnValue = "non-circular"; // this.getValue(result);
  log.debug("Method Return value : " + returnValue);
 }
 //After -&gt; Any method within resource annotated with @Controller annotation 
 // throws an exception ...Log it
//  @AfterThrowing(pointcut = "controller() &amp;&amp; allMethod()", throwing = "exception")
 @AfterThrowing(pointcut = "nonCircular() && logAnyFunctionWithinResource() && allMethod()", throwing = "exception")
 public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
  log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
  log.error("Cause : " + exception.getCause());
 }
 //Around -&gt; Any method within resource annotated with @Controller annotation 
//  @Around("controller() &amp;&amp; allMethod()")
 @Around("nonCircular() && logAnyFunctionWithinResource() && allMethod()")
 public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
  
  long start = System.currentTimeMillis();
  try {
   String className = joinPoint.getSignature().getDeclaringTypeName();
   String methodName = joinPoint.getSignature().getName();
   Object result = joinPoint.proceed();
   long elapsedTime = System.currentTimeMillis() - start;
   log.debug("Method " + className + "." + methodName + " ()" + " execution time : "
     + elapsedTime + " ms");
  
   return result;
  } catch (IllegalArgumentException e) {
   log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
     + joinPoint.getSignature().getName() + "()");
   throw e;
  }
 }
//  private String getValue(Object result) {
//   String returnValue = null;
//   if (null != result) {
//    if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
//     returnValue = ReflectionToStringBuilder.toString(result);
//    } else {
//     returnValue = result.toString();
//    }
//   }
//   return returnValue;
//  }
}

*/