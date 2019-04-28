package com.whc.test;

import org.junit.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import com.sun.glass.ui.Application;
import com.whc.config.MainConfig06LifeCycle;
import com.whc.model.Car;

import javafx.fxml.Initializable;

public class LifeCycleTest {
	
	@Test
	public void Method01test(){
		
		//1.��ȡIOC����
		ApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext(MainConfig06LifeCycle.class);
		//2.��ӡһ��������Ϣ
		System.out.println("IOC �����������");
		
		//3.�ر�IOC��������ʱbean�����ٷ����Żᱻ����
			//����ʱ��applicationContext��Ҫ����ǿתһ�²ſ���
		((AbstractApplicationContext) applicationContext).close();
		/**
		 * ����������ָ�� @bean ��init �� destroy����
		 * 		@Bean(value="car",initMethod="init",destroyMethod="destroy")
		 * �����н��Ϊ �� 
		 * 		��IOC��������֮ǰ��ʵ������ͻᴴ�����
		 * 		���Ƕ�ʵ������ֻ���ڻ�ȡ�����ʱ��Żᱻ����
		 * 	Car ... Constructer...
		 *  Car ... Init...
		 *  IOC �����������
		 *  Car ... Destroy...
		 */
	}
	
	@Test
	public void Method02test(){
		//1.��ȡIOC������ͨ���Զ�ɨ��ķ�ʽ+������һ��bean�ķ�ʽ��������
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig06LifeCycle.class);
		//2.��ӡһ�������Ϣ
		System.out.println("IOC�����������");
		/**
		 * ��javaBean�� ʵ�� Initializable, DisposableBean�����ӿںͽӿ��еķ���
		 * �൱��д��һ����ʼ��������һ�����ٷ���
		 */
		//3.�ر�IOC����
		((AbstractApplicationContext) applicationContext).close();
		
		/**
		 * ��������н���� �� 
		 * 	Car2 ... Contructor...
		 *	Car2 ...Initiaolize...
		 *	Car ... Constructer...
		 *	Car ... Init...
		 *	IOC�����������
		 *	Car ... Destroy...
		 *	Car2 ... Destroy...
		 */
	}
	
	@Test
	public void Method03test(){
		//1.��ȡIOC����
		ApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext (MainConfig06LifeCycle.class);
		//2.��ӡһ����ʾ��Ϣ
		System.out.println("IOC �����������");
		
		//3.�ر�IOC ����
		((AbstractApplicationContext) applicationContext).close();
		
		/**
		 * 
		 * ִ�еĽ���������� �� 
		 * 	Car2 ... Contructor...
		 *	Car2 ...Initiaolize...
		 *	Car3 ... Constructor...
		 *	Car3 ... init...
		 *	Car ... Constructer...
		 *	Car ... Init...
		 *	IOC �����������
		 *	Car ... Destroy...
		 *	Car3 ... destroy...
		 *	Car2 ... Destroy...
		 */
	}

}
