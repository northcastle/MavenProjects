package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.whc.config.MainConfig07PropertyValue;
import com.whc.model.Pserson;

public class PropertyValueTest {
	
	@Test
	public void testValue01(){
		//1.获取IOC容器
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig07PropertyValue.class);
		//2.获取所有的Bean
		String [] names = applicationContext.getBeanDefinitionNames();
		//3.打印所有的bean的名字
		for (String name : names) {
			System.out.println(name);
		}
		//4.获取person这个bean
		Pserson pserson = (Pserson) applicationContext.getBean("person");
		//5.打印一下这个pserson对象
		System.out.println(pserson);
	}
	
	@Test
	public void testValue02(){
		//1.获取IOC容器
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig07PropertyValue.class);
		//2.获取环境变量的对象
		Environment environment =  applicationContext.getEnvironment();
		//3.通过环境变量的对象获取属性文件中的属性
		String nickname =  environment.getProperty("person.nickname");
		//4.打印一下获取到的属性值
		System.out.println(nickname);
	}
	
	

}
