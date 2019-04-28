package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig04;

public class ImportTest {
	
	@Test
	public void classImportTest(){
		//1.第一步永远是获取到IOC容器
		ApplicationContext applicationContext 
		                                = new AnnotationConfigApplicationContext(MainConfig04.class);
		
		//2.我可以看一下所有已经注册了的bean的名字
		String [] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("-->"+name);
			/**
			 * 会把注册的全类名打印出来的
			 * -->com.whc.model.Color
			 *	-->user01
			 */
		}
	}

}
