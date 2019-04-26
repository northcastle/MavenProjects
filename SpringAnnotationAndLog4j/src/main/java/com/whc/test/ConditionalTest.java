package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.whc.config.MainConfig03;

public class ConditionalTest {
	
	
	/**
	 * 这个test只是简单的使用一下获取Environment这个类和对象
	 */
	@Test
	public void testConditional(){
		//1.获取配置类
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig03.class);
		//2.获取所有的注册了的Bean
		String[] names =  applicationContext.getBeanDefinitionNames();
		for(String name : names){
			System.out.println("--->"+name);
		}
		//3.获取当前操作系统的名字
		Environment environment =  applicationContext.getEnvironment();
		String systemName = environment.getProperty("os.name");
		System.out.println("===>"+systemName);
	}

}
