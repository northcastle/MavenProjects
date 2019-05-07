package com.whc.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.aop.MyCalculater;
import com.whc.config.MainConfig10Aspect;


public class AopTest {
	
	@Test
	public void testAOP(){
		//1.获取容器
		AnnotationConfigApplicationContext applicationContext
							= new AnnotationConfigApplicationContext();
		applicationContext.register(MainConfig10Aspect.class);
		applicationContext.refresh();
		
		//2.获取容器中的所有组件名称
		String[] names =  applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		//3.获取MyCalculater的一个对象，并且执行该对象的division方法
		MyCalculater myCalculater =  (MyCalculater) applicationContext.getBean("MyCalculater");
		myCalculater.division(10, 0);
		myCalculater.division2(10, 0);
	}

}
