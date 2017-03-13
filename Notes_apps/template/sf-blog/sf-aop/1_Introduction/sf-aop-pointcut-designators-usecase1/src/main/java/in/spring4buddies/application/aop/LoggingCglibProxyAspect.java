package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingCglibProxyAspect {

	// this pcd
	@Pointcut("this(in.spring4buddies.application.dao.TradeDaoImpl)")
	public void daoMethod() {

	}

	@Before("daoMethod()")
	public void logBeforeDaoMethod(JoinPoint joinPoint) {
		System.out.println("PCD - this() LoggingCglibProxyAspect.logBeforeDaoMethod() : daoMethod() : " + joinPoint.getSignature().getName());
	}
}