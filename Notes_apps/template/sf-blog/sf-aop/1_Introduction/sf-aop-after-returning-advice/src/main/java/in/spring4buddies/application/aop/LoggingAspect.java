package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@AfterReturning(returning = "retVal", pointcut = "execution(* in.spring4buddies.application.service.*.*(..))")
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println("LoggingAspect.logAfterReturning() " + joinPoint.getSignature().getName() + " : retVal :" + retVal);
	}
}