package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@AfterThrowing(pointcut = "execution(* in.spring4buddies.application.service.*.*(..))", throwing = "ex")
	public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("LoggingAspect.logAfterThrowing() " + joinPoint.getSignature().getName() + " : Exception :" + ex);
	}
}