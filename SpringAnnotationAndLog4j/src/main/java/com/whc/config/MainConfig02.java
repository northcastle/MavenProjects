package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.whc.model.User;

public class MainConfig02 {

	/**
	 * 默认情况下，bean是单实例的
	 * （1）单实例的情况下(singleton)：当IOC 容器启动时就会调用方法创建对象，
	 * 					以后每次获取会直接从容器中拿去对象，故每次拿去的对象都是同一个
	 * （2）多实例的情况下(prototype)：当获取bean的时候才会创建对象，
	 * 					以后每次获取会重新创建一个对象，故每次拿去的对象都是一个新的的对象
	 * @return
	 */
	@Scope("prototype")
	@Bean("user")
	public User user() {
		System.out.println("User 被创建！");
		return new User("张三", 22);
	}
	/**
	 *  懒加载(lazy) : 专门针对单实例的对象
	 *  	单实例bean : 默认情况IOC容器启动的时候创建对象
	 *  	懒加载 ： 容器启动不创建对象，在第一次使用对象是，创建对象，并初始化
	 * @return
	 */
	@Lazy
	@Bean("user02")
	public User user02() {
		System.out.println("User02 被创建！");
		return new User("李四", 22);
	}
}
