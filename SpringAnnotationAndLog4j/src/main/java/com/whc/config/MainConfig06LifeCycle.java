package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.whc.model.Car;
import com.whc.model.Car2;

@ComponentScan("com.whc.model") // ʹ���Զ�ɨ��ķ�ʽ��������
@Configuration
public class MainConfig06LifeCycle {
	
	/**
	 * �������ڷ�ʽһ��ʹ��@beanע���еĲ���ָ����ʼ�����������ٷ���
	 * @return
	 */
	@Bean(value="car",initMethod="init",destroyMethod="destroy")
	public Car car(){
		return new Car();
	}
	
	/**
	 * ��bean�ĺ��ô��������뵽��������
	 */
	@Bean()
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}
}
