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

//	// @args pcd
//	@Pointcut("@args(javax.persistence.Entity)")
//	public void methodsAcceptingEntities() {
//	}
//
//	// @within pcd
//	@Pointcut("@within(org.springframework.stereotype.Repository)")
//	public void withinAnnotation() {
//
//	}
//	
//	@Before("withinAnnotation()")
//	public void logBeforeWithinAnnotation(JoinPoint joinPoint) {
//		System.out.println("PCD - @target() LoggingAspect.logBeforeWithinAnnotation() : " + joinPoint.getSignature().getName());
//	}
//
//	// @annotation pcd
//	@Pointcut("@annotation(*.annotations.Loggable)")
//	public void loggableMethods() {
//	}

}