package com.whc.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component("MyCalculaterAspect")
public class MyCalculaterAspect {
	
	@Pointcut(value="execution(public * com.whc.aop.MyCalculater.*(..))")
	public void pointcut(){}
	
	@Before(value="pointcut()")
	public void logBefore(JoinPoint joinPoint){
		//可以获取参数
		Object[] args =  joinPoint.getArgs();
		//可以获取方法名称
		String methodName = joinPoint.getSignature().getName();
		//打印信息
		System.out.println(methodName+" : @Before ，运行参数是 ： "+Arrays.asList(args));
	}
	
	@After(value="pointcut()")
	public void logAfter(JoinPoint joinPoint){
		//可以获取方法名称
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+" : @After ，运行结束 ");
	}

	@AfterReturning(value="pointcut()",returning="divResult")
	public void logAfterReturning(JoinPoint joinPoint,Object divResult){
		//可以获取方法名称
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + " : @AfterReturning,运行结果是 ： "+divResult);
	}
	
	@AfterThrowing(value="pointcut()",throwing="exception")
	public void logThrowing(JoinPoint joinPoint,Exception exception){
		//可以获取方法名称
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + " : @AfterThrowing,运行异常是 ： "+exception.getLocalizedMessage());
	}
}
