package com.whc.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Car3 {
	public Car3(){
		System.out.println("Car3 ... Constructor...");
	}
	
	@PostConstruct // JSR250 中的标准注解方式 ： 作为初始化的方法
	public void init(){
		System.out.println("Car3 ... init...");
	}
	@PreDestroy // JSR250种的标准注解方式：作为销毁方法
	public void destroy(){
		System.out.println("Car3 ... destroy...");
	}

}
