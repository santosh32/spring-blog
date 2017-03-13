package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}

	public void logAfter(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfter() : " + joinPoint.getSignature().getName());
	}

	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println("LoggingAspect.logAfterReturning() " + joinPoint.getSignature().getName() + " : retVal :" + retVal);
	}

	public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("LoggingAspect.logAfterThrowing() " + joinPoint.getSignature().getName() + " : Exception :" + ex);
	}

	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("LoggingAspect.logAround() : before : " + pjp.getSignature().getName());
		Object object = pjp.proceed();
		System.out.println("LoggingAspect.logAround() : after : " + pjp.getSignature().getName());
		return object;
	}
}