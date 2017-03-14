/*package in.spring4buddies.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	@Pointcut("call (public * org.apache.commons.logging.Log.info(..))")
	public void commonsLogging() {
	}

	@Pointcut("call (public void org.slf4j.Logger.error(..)) || call (public void org.slf4j.Logger.warn(..)) || call (public void org.slf4j.Logger.info(..))")
	public void slf4jLogging() {
	}

	@Around("commonsLogging() || slf4jLogging()")
	public void injectMessagedToLogger(ProceedingJoinPoint pjp) {
		try {
			Object[] args = pjp.getArgs();
			if (args == null) { // shouldn't happen, but we don't want NPE
				pjp.proceed();
				return;
			}
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				if (arg instanceof String) {
					args[i] = addPrefixToMessage((String) args[i]);
				}
			}
			pjp.proceed(args);
		} catch (Throwable e) {
			// Can't log this, because it will cause an infinite loop
			e.printStackTrace();
		}
	}

	private String addPrefixToMessage(String arg) {
		return "$$$ hijacked by AOP ! $$$ " + arg;
	}

}
*/