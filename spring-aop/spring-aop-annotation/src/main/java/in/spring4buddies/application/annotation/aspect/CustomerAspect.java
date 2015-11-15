package in.spring4buddies.application.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerAspect {

	@Autowired
	@Before("execution(* in.spring4buddies.application.annotation.autowired.CustomerDao.get*(..))")
	public void logBeforeGetMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logBeforeGetMethod() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* in.spring4buddies.application.annotation.autowired.CustomerDao.*(..))")
	public void logBeforeAllMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logBeforeAllMethod() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* CustomerDao.get*(..))")
	public void logAfterGetMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logAfterGetMethod() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* CustomerDao.create*(..))")
	public void logAfterCreateMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logAfterCreateMethod() : " + joinPoint.getSignature().getName());
	}
}
