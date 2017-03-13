package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* in.spring4buddies.application.service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* in.spring4buddies.application.service.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfter() : " + joinPoint.getSignature().getName());
	}

	@AfterReturning(returning = "retVal", pointcut = "execution(* in.spring4buddies.application.service.*.*(..))")
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println("LoggingAspect.logAfterReturning() " + joinPoint.getSignature().getName() + " : retVal :" + retVal);
	}

	@AfterThrowing(pointcut = "execution(* in.spring4buddies.application.service.*.*(..))", throwing = "ex")
	public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("LoggingAspect.logAfterThrowing() " + joinPoint.getSignature().getName() + " : Exception :" + ex);
	}

//	@Around("execution(* in.spring4buddies.application.service.*.*(..))")
//	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("LoggingAspect.logAround() : before : " + pjp.getSignature().getName());
//		pjp.proceed();
//		System.out.println("LoggingAspect.logAround() : after : " + pjp.getSignature().getName());
//	}
}