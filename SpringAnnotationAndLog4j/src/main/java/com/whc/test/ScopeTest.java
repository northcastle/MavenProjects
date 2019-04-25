package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig02;
import com.whc.model.User;

public class ScopeTest {
	
	@Test
	public void testScopeSingleton() {
		//1.获取Ioc容器
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		/**
		 * 只创建IOC容器，但是 控制台会打印 “ User 被创建！”即创建对象时候调用的方法中的打印信息
		 */
	}
	
	@Test
	public void testScopePrototype() {
		//1.获取Ioc容器
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		/**
		 * 只创建IOC容器，控制台没有任何信息可以打印出来
		 */
		//2.获取bean
		User usera = (User) applicationContext.getBean("user");
		/**
		 * 获取对象的时候：控制台会打印 “ User 被创建！”即创建对象时候调用的方法中的打印信息
		 */
		//3.获取第二个bean，比较两个对象
		User userb = (User) applicationContext.getBean("user");
		//4.比较两个对象是否相等
		System.out.println(usera == userb);
		/**
		 * 1.控制台会打印两遍 “ User 被创建！”，因为获取了两个User对象
		 * 2.比较两个对象是否相等：false==>两个对象不相等！
		 */
	}
	
	@Test
	public void testScopeLazy() {
		//1.获取Ioc容器
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		System.out.println("IOC 容器 启动完成。。。");
		/**
		 * 只创建IOC容器，控制台没有任何信息可以打印出来
		 */
		//2.获取bean
		User usera = (User) applicationContext.getBean("user02");
		/**
		 * 获取对象的时候：控制台会打印 “ User02 被创建！”即创建对象时候调用的方法中的打印信息
		 */
	}
	

}
