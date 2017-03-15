package in.spring4buddies.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ProfilingAspect {


//	@AfterThrowing(pointcut = "execution(* in.spring4buddies.application.aop.*.* (..))", throwing = "e")
//	public void handleError(Throwable e) {
//		logger.error("--- AOP INTERCEPTED ERROR ---", e);
//	}
	
	@Around("methodsToBeProfiled()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch(getClass().getSimpleName());
		try {
			sw.start(pjp.getSignature().getName());
			return pjp.proceed();
		} finally {
			sw.stop();
			System.out.println(sw.prettyPrint());
		}
	}

	@Pointcut("execution(* in.spring4buddies.application.service.*.* (..))")
	public void methodsToBeProfiled() {
	}
}
