package com.whc.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * 这个是对所有的bean都起作用的
 * @author 10156234c
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("初始化之前调用 ： "+beanName);
		//return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("初始化之后调用 ： "+beanName);
		//return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		return bean;
	}
	
}
