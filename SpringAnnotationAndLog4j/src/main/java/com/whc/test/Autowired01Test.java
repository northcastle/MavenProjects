package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig08Autowired;
import com.whc.controller.UserController;
import com.whc.model.Boss;

public class Autowired01Test {
	
	@Test
	public void autowired01Test(){
		//1.创建IOC容器
		ApplicationContext applicationContext 
						= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.获取Controller对象，并打印，
			// 此时的对象应该是包含UserServiceImpl对象的，而UserServiceImpl对象又包含UserMapper接口对象
		 UserController controller1 =  applicationContext.getBean(UserController.class);
		 System.out.println(controller1);
	}
	
	@Test
	public void autowired02Test(){
		//1.创建IOC容器
		ApplicationContext applicationContext 
						= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.获取Controller对象，并打印，
			// 此时的对象应该是包含UserServiceImpl对象的，而UserServiceImpl对象又包含UserMapper接口对象
		 UserController controller1 =  applicationContext.getBean(UserController.class);
		 System.out.println(controller1);
	}
	
	@Test
	public void autowired03Test(){
		//1.创建IOC容器
		ApplicationContext applicationContext 
							= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.获取house对象并打印
		Boss boss =  (Boss) applicationContext.getBean("boss");
		System.out.println(boss);
		
		//3.再获取一个boss2
		Boss boss2 =  (Boss) applicationContext.getBean("boss2");
		System.out.println(boss2);
	}

}
