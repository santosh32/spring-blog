package in.spring4buddies.application.annotation.within.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WithinAspect {

	@Before("logCustomer()")
	public void logBeforeGetMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logBeforeGetMethod() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* in.spring4buddies.application.annotation.autowired.CustomerDao.getAll*(..))")
	public void logBeforeAllMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logBeforeAllMethod() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* in.spring4buddies.application.annotation.autowired.CustomerDao.get*(..))")
	public void logAfterGetMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logAfterGetMethod() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* in.spring4buddies.application.annotation.autowired.CustomerDao.create*(..))")
	public void logAfterCreateMethod(JoinPoint joinPoint) {
		System.out.println("CustomerAspect.logAfterCreateMethod() : " + joinPoint.getSignature().getName());
	}
	
	@Pointcut("within(in.spring4buddies.application.annotation.autowired.*)")
	public void logWithinPointcut() {
	}
	
	@Pointcut("execution(* *get*(..))")
	public void logExecutionPointcut() {
	}
	
	@Pointcut("logWithinPointcut() && logExecutionPointcut()")
	public void logCustomer() {
	}
}
