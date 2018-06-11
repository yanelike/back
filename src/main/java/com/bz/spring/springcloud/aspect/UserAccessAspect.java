package com.bz.spring.springcloud.aspect;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bz.spring.springcloud.backend.exception.UnauthorizedException; 
 

@Aspect
@Component
public class UserAccessAspect {
	
	private static final Logger logger = Logger.getLogger(UserAccessAspect.class.getName());
	

	@Before("execution(* com.bz.spring.springcloud.backend.controller.*.*(..))")
	public void before(final JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        if (!isAdmin(request)) {
        	throw new UnauthorizedException("Ops Unauthorized");
        }
	}
	private static boolean isAdmin(final HttpServletRequest request) {
        String authorization = request.getHeader("X-3scale-proxy-secret-token");
        logger.info("Header ["+ authorization+"]");
        return authorization != null
                && authorization.equalsIgnoreCase("250192010292Like");
    }
	
//	@Around("execution(* com.bz.spring.springcloud.backend.controller.*.*(..))")
//	public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                .currentRequestAttributes())
//                .getRequest();
//
//        Object value;
//
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throw throwable;
//        } finally {
//        	logger.info(
//                    "{} {} from {}"+
//                    request.getMethod()+
//                    request.getRequestURI()+
//                    request.getRemoteAddr()+
//                    request.getHeader("user-id"));
//        }
//
//        return value;
//    }
}
	