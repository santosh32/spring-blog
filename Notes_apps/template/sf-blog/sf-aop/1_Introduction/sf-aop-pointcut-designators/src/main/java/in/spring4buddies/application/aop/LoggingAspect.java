package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* in.spring4buddies.application.dao.TradeDaoImpl.getTradeByType(..))")
	public void daoMethod() {

	}

	@Before("daoMethod()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore() : " + joinPoint.getSignature().getName());
	}
}