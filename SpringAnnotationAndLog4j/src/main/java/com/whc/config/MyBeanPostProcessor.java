package com.whc.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * ����Ƕ����е�bean�������õ�
 * @author 10156234c
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��֮ǰ���� �� "+beanName);
		//return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��֮����� �� "+beanName);
		//return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		return bean;
	}
	
}
