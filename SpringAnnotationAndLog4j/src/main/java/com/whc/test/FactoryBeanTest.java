package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig05;
import com.whc.config.MyColorFactoryBean;
import com.whc.model.Color;

public class FactoryBeanTest {
	
	@Test
	public void FactoryBeantest(){
		//1.获取IOC 容器
		ApplicationContext applicationContext 
					= new AnnotationConfigApplicationContext(MainConfig05.class);
		//2.获取工厂bean对象:但是返回值却是getOjbect()方法的返回值
		Color myColorFactoryBean =  (Color) applicationContext.getBean("colorFactoryBean");
		System.out.println(myColorFactoryBean.getClass());
		/**
		 * 返回的结果是这一个
		 * class com.whc.model.Color
		 */
	}

}
