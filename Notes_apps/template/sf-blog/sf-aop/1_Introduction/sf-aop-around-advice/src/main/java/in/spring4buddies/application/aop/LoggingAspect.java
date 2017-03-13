package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("execution(* in.spring4buddies.application.service.*.*(..))")
	public void logAround(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAround() : " + joinPoint.getSignature().getName());
	}
}