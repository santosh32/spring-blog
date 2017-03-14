package in.spring4buddies.application.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlerAspect {

	private static Logger logger = LoggerFactory.getLogger(ErrorHandlerAspect.class);

	@AfterThrowing(pointcut = "execution(* in.spring4buddies.application.aop.*.* (..))", throwing = "e")
	public void handleError(Throwable e) {
		logger.error("--- AOP INTERCEPTED ERROR ---", e);
	}
}
