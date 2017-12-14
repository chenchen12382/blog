package com.chenchen.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/12/14.
 */

@Component
@Aspect
public class LoginProxy {

    @Autowired
    private HttpServletRequest request;

    /**
     * 切入点
     */
    @Pointcut("execution(* com.chenchen.controller.*.*(..))")
    public void pointcut() {

    }

//    @Around(value = "pointcut()")
//    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
//
////        String uri = request.getRequestURI();
////        String path=request.getContextPath();
////        if (!"/article/index".equals(uri) || !"/login".equals(uri)) { // 放行
////            return pjp.proceed();
////        }
//        return null;
//    }


}
