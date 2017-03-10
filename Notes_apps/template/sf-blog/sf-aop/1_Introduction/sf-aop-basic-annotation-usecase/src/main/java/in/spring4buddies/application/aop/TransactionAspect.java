package in.spring4buddies.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

	@Before("execution(* in.spring4buddies.application.service.TradeServiceImpl.getTradeByType(..))")
	public void getByType(JoinPoint joinPoint) {
		System.out.println("TransactionAspect.getByType() : " + joinPoint.getSignature().getName());
	}
}