package com.nkds.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nkds.common.exception.NamBizException;
import com.nkds.web.model.User;

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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("execution(* com.nkds.web.controller.RestUriController.*(..))")
	public Object rest(ProceedingJoinPoint joinPoint) {
		ResponseEntity rtnEntity = null;
		
		try {
			rtnEntity = (ResponseEntity)joinPoint.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
        
		if (rtnEntity.hasBody() == false) {
            return new ResponseEntity(new NamBizException("An internal server error occured"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
		return rtnEntity;
	}

}