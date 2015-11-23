package in.spring4buddies.application.annotation.execution.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionAspect {

	@Before("logGet()")
	public void logBeforeGetMethod(JoinPoint joinPoint) {
		System.out.println("logBeforeGetMethod() called before "
				+ joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName());
	}

	@Before("logGetAll()")
	public void logBeforeAllMethod(JoinPoint joinPoint) {
		System.out.println("logBeforeGetAllMethod() : "
				+ joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName());
	}

	@After("logGet()")
	public void logAfterGetMethod(JoinPoint joinPoint) {
		System.out.println("logAfterGetMethod() : "
				+ joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName());
	}

	@After("logCreate()")
	public void logAfterCreateMethod(JoinPoint joinPoint) {
		System.out.println("logAfterCreateMethod() : "
				+ joinPoint.getTarget().getClass() + "."
				+ joinPoint.getSignature().getName());
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.*(..))")
	public void log() {
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.get*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.get*(..))")
	public void logGet() {
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.create*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.create*(..))")
	public void logCreate() {
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.delete*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.delete*(..))")
	public void logDelete() {
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.update*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.update*(..))")
	public void logUpdate() {
	}

	@Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.getAll*())")
	// @Pointcut("execution(* in.spring4buddies.application.annotation.autowired.*.getAll*(..))")
	public void logGetAll() {
	}
}
