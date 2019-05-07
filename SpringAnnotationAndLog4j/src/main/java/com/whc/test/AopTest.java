package com.whc.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.aop.MyCalculater;
import com.whc.config.MainConfig10Aspect;


public class AopTest {
	
	@Test
	public void testAOP(){
		//1.��ȡ����
		AnnotationConfigApplicationContext applicationContext
							= new AnnotationConfigApplicationContext();
		applicationContext.register(MainConfig10Aspect.class);
		applicationContext.refresh();
		
		//2.��ȡ�����е������������
		String[] names =  applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		//3.��ȡMyCalculater��һ�����󣬲���ִ�иö����division����
		MyCalculater myCalculater =  (MyCalculater) applicationContext.getBean("MyCalculater");
		myCalculater.division(10, 0);
		myCalculater.division2(10, 0);
	}

}
