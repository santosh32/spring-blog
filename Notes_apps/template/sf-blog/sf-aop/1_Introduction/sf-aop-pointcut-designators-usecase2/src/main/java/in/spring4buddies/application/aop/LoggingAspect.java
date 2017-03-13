package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// @target pcd
	@Pointcut("@target(org.springframework.stereotype.Repository)")
	public void targetAnnotation() {

	}

	@Before("targetAnnotation()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("PCD - @target() LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}

}