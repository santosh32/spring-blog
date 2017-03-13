package in.spring4buddies.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("execution(* in.spring4buddies.application.service.*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("LoggingAspect.logAround() : before : " + pjp.getSignature().getName());
		Object object = pjp.proceed();
		System.out.println("LoggingAspect.logAround() : after : " + pjp.getSignature().getName());
		return object;
	}
}