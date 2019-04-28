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
		//1.��ȡIOC ����
		ApplicationContext applicationContext 
					= new AnnotationConfigApplicationContext(MainConfig05.class);
		//2.��ȡ����bean����:���Ƿ���ֵȴ��getOjbect()�����ķ���ֵ
		Color myColorFactoryBean =  (Color) applicationContext.getBean("colorFactoryBean");
		System.out.println(myColorFactoryBean.getClass());
		/**
		 * ���صĽ������һ��
		 * class com.whc.model.Color
		 */
	}

}
