package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Aspect
@Component
public class TransactionAspect {

	@Before("execution(* in.spring4buddies.application.service.*.*(..))")
	public void txnBefore(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.txnBefore() : " + joinPoint.getSignature().getName());
	}
}