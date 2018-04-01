package com.nkds.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AspectConfig {
	private static final Logger logger = LoggerFactory.getLogger(AspectConfig.class);
	
	@Around("execution(* com.nkds.web.service..*.*(..))")
	public Object executionTime(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		Object returnVal = null;
		
		try {
			returnVal = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		
		long finishTime = System.currentTimeMillis();
		
		Signature signature = joinPoint.getSignature();
		
		logger.info(signature.getDeclaringTypeName()+"."+signature.getName()+": {} ms",(finishTime - startTime));
		
		return returnVal;
	}

}