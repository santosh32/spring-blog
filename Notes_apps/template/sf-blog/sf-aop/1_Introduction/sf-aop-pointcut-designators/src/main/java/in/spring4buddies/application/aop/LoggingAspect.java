package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// execution pcd- this is like package level or any level like method,
	// method parameters level
	@Pointcut("execution(* in.spring4buddies.application.dao.TradeDaoImpl.getTradeByType(..))")
	public void daoGetMethod() {

	}

	@Before("daoGetMethod()")
	public void logBeforeDaoGetMethod(JoinPoint joinPoint) {
		System.out.println("PCD - execution() LoggingAspect.logBeforeDaoGetMethod() : daoGetMethod() : " + joinPoint.getSignature().getName());
	}

	// within pcd - this is package level only
	@Pointcut("within(in.spring4buddies.application.dao.TradeDaoImpl)")
	public void daoMethod() {

	}

	@Before("daoMethod()")
	public void logBeforeDaoAddMethod(JoinPoint joinPoint) {
		System.out.println("PCD - within() LoggingAspect.logBeforeDaoAddMethod() : daoMethod() : " + joinPoint.getSignature().getName());
	}

	// args pcd
	@Pointcut("execution(* in.spring4buddies.application.service.*.get*(String))")
	public void serviceGetMethod() {

	}

	@After("serviceGetMethod()")
	public void logAfterServiceGetMethod(JoinPoint joinPoint) {
		System.out.println("PCD - args() LoggingAspect.logAfterServiceGetMethod() : serviceGetMethod() : " + joinPoint.getSignature().getName());
	}
}