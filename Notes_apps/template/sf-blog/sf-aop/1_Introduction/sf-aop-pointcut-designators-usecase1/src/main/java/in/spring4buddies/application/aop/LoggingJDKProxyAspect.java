package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingJDKProxyAspect {

	// target pcd
	@Pointcut("target(in.spring4buddies.application.service.TradeServiceImpl)")
	public void serviceMethod() {

	}

	@Before("serviceMethod()")
	public void logBeforeServiceMethod(JoinPoint joinPoint) {
		System.out.println("PCD - target() LoggingJDKProxyAspect.logBeforeServiceMethod() : serviceMethod() : " + joinPoint.getSignature().getName());
	}
}