package com.guet.controller;

import com.guet.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author MicahYin
 * @date 2019/11/28 10:36
 */
//@Component
//@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//访问时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

//    @Before("execution(* com.guet.service.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodError{
        System.out.println("进行了登录操作");
    }

//    @After("execution(* com.guet.service.impl.IUserServiceImp.loadUserByUsername(..))")
    public void doAfter(JoinPoint jp) throws Exception{
        System.out.println("登录操作完成.....");
    }
}
