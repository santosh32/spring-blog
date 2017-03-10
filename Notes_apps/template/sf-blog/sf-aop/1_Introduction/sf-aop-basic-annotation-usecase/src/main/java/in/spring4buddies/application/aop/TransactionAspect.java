package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;

public class TransactionAspect {

	public void getByType(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.getByType() : " + joinPoint.getSignature().getName());
	}
}