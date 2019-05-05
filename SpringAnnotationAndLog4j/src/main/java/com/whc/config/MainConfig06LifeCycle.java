package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.whc.model.Car;
import com.whc.model.Car2;

@ComponentScan("com.whc.model") // 使用自动扫描的方式进行配置
@Configuration
public class MainConfig06LifeCycle {
	
	/**
	 * 生命周期方式一：使用@bean注解中的参数指定初始化方法和销毁方法
	 * @return
	 */
	@Bean(value="car",initMethod="init",destroyMethod="destroy")
	public Car car(){
		return new Car();
	}
	
	/**
	 * 把bean的后置处理器放入到配置类中
	 */
	@Bean()
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}
}
