package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}

	public void logAfter(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfter() : " + joinPoint.getSignature().getName());
	}
}