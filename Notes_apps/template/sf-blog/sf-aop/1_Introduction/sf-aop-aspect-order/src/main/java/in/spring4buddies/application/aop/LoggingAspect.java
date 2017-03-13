package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class LoggingAspect { //implements Ordered {
	
//	@Override
//	public int getOrder() {
//		return 0;
//	}

	@Before("execution(* in.spring4buddies.application.service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}
}