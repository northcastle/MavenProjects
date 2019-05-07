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
		//���Ի�ȡ����
		Object[] args =  joinPoint.getArgs();
		//���Ի�ȡ��������
		String methodName = joinPoint.getSignature().getName();
		//��ӡ��Ϣ
		System.out.println(methodName+" : @Before �����в����� �� "+Arrays.asList(args));
	}
	
	@After(value="pointcut()")
	public void logAfter(JoinPoint joinPoint){
		//���Ի�ȡ��������
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+" : @After �����н��� ");
	}

	@AfterReturning(value="pointcut()",returning="divResult")
	public void logAfterReturning(JoinPoint joinPoint,Object divResult){
		//���Ի�ȡ��������
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + " : @AfterReturning,���н���� �� "+divResult);
	}
	
	@AfterThrowing(value="pointcut()",throwing="exception")
	public void logThrowing(JoinPoint joinPoint,Exception exception){
		//���Ի�ȡ��������
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + " : @AfterThrowing,�����쳣�� �� "+exception.getLocalizedMessage());
	}
}
