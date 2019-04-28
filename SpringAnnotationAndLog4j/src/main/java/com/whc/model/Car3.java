package com.whc.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Car3 {
	public Car3(){
		System.out.println("Car3 ... Constructor...");
	}
	
	@PostConstruct // JSR250 �еı�׼ע�ⷽʽ �� ��Ϊ��ʼ���ķ���
	public void init(){
		System.out.println("Car3 ... init...");
	}
	@PreDestroy // JSR250�ֵı�׼ע�ⷽʽ����Ϊ���ٷ���
	public void destroy(){
		System.out.println("Car3 ... destroy...");
	}

}
