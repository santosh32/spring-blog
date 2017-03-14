package in.spring4buddies.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("execution(* in.spring4buddies.application.service.*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		Object object = null;

		System.out.println("LoggingAspect.logAround() : before : " + pjp.getSignature().getName());
		long t0 = System.currentTimeMillis();

		try {
			object = pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		long t1 = System.currentTimeMillis();
		String methodName = pjp.getSignature().getName();

		System.out.println(Thread.currentThread().getName() + " method: " + methodName + " took " + (t1 - t0) + " milliseconds");

		System.out.println("LoggingAspect.logAround() : after : " + pjp.getSignature().getName());
		return object;
	}
}