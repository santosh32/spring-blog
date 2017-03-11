package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@After("execution(* in.spring4buddies.application.service.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfter() : " + joinPoint.getSignature().getName());
	}
}