package com.whc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig02;
import com.whc.model.User;

public class ScopeTest {
	
	@Test
	public void testScopeSingleton() {
		//1.��ȡIoc����
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		/**
		 * ֻ����IOC���������� ����̨���ӡ �� User ��������������������ʱ����õķ����еĴ�ӡ��Ϣ
		 */
	}
	
	@Test
	public void testScopePrototype() {
		//1.��ȡIoc����
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		/**
		 * ֻ����IOC����������̨û���κ���Ϣ���Դ�ӡ����
		 */
		//2.��ȡbean
		User usera = (User) applicationContext.getBean("user");
		/**
		 * ��ȡ�����ʱ�򣺿���̨���ӡ �� User ��������������������ʱ����õķ����еĴ�ӡ��Ϣ
		 */
		//3.��ȡ�ڶ���bean���Ƚ���������
		User userb = (User) applicationContext.getBean("user");
		//4.�Ƚ����������Ƿ����
		System.out.println(usera == userb);
		/**
		 * 1.����̨���ӡ���� �� User ��������������Ϊ��ȡ������User����
		 * 2.�Ƚ����������Ƿ���ȣ�false==>����������ȣ�
		 */
	}
	
	@Test
	public void testScopeLazy() {
		//1.��ȡIoc����
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig02.class);
		System.out.println("IOC ���� ������ɡ�����");
		/**
		 * ֻ����IOC����������̨û���κ���Ϣ���Դ�ӡ����
		 */
		//2.��ȡbean
		User usera = (User) applicationContext.getBean("user02");
		/**
		 * ��ȡ�����ʱ�򣺿���̨���ӡ �� User02 ��������������������ʱ����õķ����еĴ�ӡ��Ϣ
		 */
	}
	

}
