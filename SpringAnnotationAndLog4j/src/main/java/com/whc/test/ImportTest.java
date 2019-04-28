package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig04;

public class ImportTest {
	
	@Test
	public void classImportTest(){
		//1.��һ����Զ�ǻ�ȡ��IOC����
		ApplicationContext applicationContext 
		                                = new AnnotationConfigApplicationContext(MainConfig04.class);
		
		//2.�ҿ��Կ�һ�������Ѿ�ע���˵�bean������
		String [] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("-->"+name);
			/**
			 * ���ע���ȫ������ӡ������
			 * -->com.whc.model.Color
			 *	-->user01
			 */
		}
	}

}
