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
		//1.��ȡIOC����
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig07PropertyValue.class);
		//2.��ȡ���е�Bean
		String [] names = applicationContext.getBeanDefinitionNames();
		//3.��ӡ���е�bean������
		for (String name : names) {
			System.out.println(name);
		}
		//4.��ȡperson���bean
		Pserson pserson = (Pserson) applicationContext.getBean("person");
		//5.��ӡһ�����pserson����
		System.out.println(pserson);
	}
	
	@Test
	public void testValue02(){
		//1.��ȡIOC����
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig07PropertyValue.class);
		//2.��ȡ���������Ķ���
		Environment environment =  applicationContext.getEnvironment();
		//3.ͨ�����������Ķ����ȡ�����ļ��е�����
		String nickname =  environment.getProperty("person.nickname");
		//4.��ӡһ�»�ȡ��������ֵ
		System.out.println(nickname);
	}
	
	

}
