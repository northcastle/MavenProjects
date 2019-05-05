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
		//1.����IOC����
		ApplicationContext applicationContext 
						= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.��ȡController���󣬲���ӡ��
			// ��ʱ�Ķ���Ӧ���ǰ���UserServiceImpl����ģ���UserServiceImpl�����ְ���UserMapper�ӿڶ���
		 UserController controller1 =  applicationContext.getBean(UserController.class);
		 System.out.println(controller1);
	}
	
	@Test
	public void autowired02Test(){
		//1.����IOC����
		ApplicationContext applicationContext 
						= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.��ȡController���󣬲���ӡ��
			// ��ʱ�Ķ���Ӧ���ǰ���UserServiceImpl����ģ���UserServiceImpl�����ְ���UserMapper�ӿڶ���
		 UserController controller1 =  applicationContext.getBean(UserController.class);
		 System.out.println(controller1);
	}
	
	@Test
	public void autowired03Test(){
		//1.����IOC����
		ApplicationContext applicationContext 
							= new AnnotationConfigApplicationContext(MainConfig08Autowired.class);
		//2.��ȡhouse���󲢴�ӡ
		Boss boss =  (Boss) applicationContext.getBean("boss");
		System.out.println(boss);
		
		//3.�ٻ�ȡһ��boss2
		Boss boss2 =  (Boss) applicationContext.getBean("boss2");
		System.out.println(boss2);
	}

}
