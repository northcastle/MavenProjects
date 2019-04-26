package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.whc.config.MainConfig03;

public class ConditionalTest {
	
	
	/**
	 * ���testֻ�Ǽ򵥵�ʹ��һ�»�ȡEnvironment�����Ͷ���
	 */
	@Test
	public void testConditional(){
		//1.��ȡ������
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig03.class);
		//2.��ȡ���е�ע���˵�Bean
		String[] names =  applicationContext.getBeanDefinitionNames();
		for(String name : names){
			System.out.println("--->"+name);
		}
		//3.��ȡ��ǰ����ϵͳ������
		Environment environment =  applicationContext.getEnvironment();
		String systemName = environment.getProperty("os.name");
		System.out.println("===>"+systemName);
	}

}
