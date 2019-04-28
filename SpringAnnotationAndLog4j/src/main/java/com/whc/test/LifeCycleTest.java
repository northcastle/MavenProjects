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
		
		//1.获取IOC容器
		ApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext(MainConfig06LifeCycle.class);
		//2.打印一条数据信息
		System.out.println("IOC 容器创建完成");
		
		//3.关闭IOC容器，此时bean的销毁方法才会被调用
			//但此时的applicationContext需要进行强转一下才可以
		((AbstractApplicationContext) applicationContext).close();
		/**
		 * 在配置类中指定 @bean 的init 和 destroy方法
		 * 		@Bean(value="car",initMethod="init",destroyMethod="destroy")
		 * 次运行结果为 ： 
		 * 		在IOC容器创建之前单实例对象就会创建完成
		 * 		但是多实例对象只会在获取对象的时候才会被创建
		 * 	Car ... Constructer...
		 *  Car ... Init...
		 *  IOC 容器创建完成
		 *  Car ... Destroy...
		 */
	}
	
	@Test
	public void Method02test(){
		//1.获取IOC容器，通过自动扫描的方式+配置了一个bean的方式创建对象
		ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(MainConfig06LifeCycle.class);
		//2.打印一条输出信息
		System.out.println("IOC容器创建完成");
		/**
		 * 在javaBean中 实现 Initializable, DisposableBean两个接口和接口中的方法
		 * 相当于写了一个初始化方法，一个销毁方法
		 */
		//3.关闭IOC容器
		((AbstractApplicationContext) applicationContext).close();
		
		/**
		 * 这个的运行结果是 ： 
		 * 	Car2 ... Contructor...
		 *	Car2 ...Initiaolize...
		 *	Car ... Constructer...
		 *	Car ... Init...
		 *	IOC容器创建完成
		 *	Car ... Destroy...
		 *	Car2 ... Destroy...
		 */
	}
	
	@Test
	public void Method03test(){
		//1.获取IOC容器
		ApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext (MainConfig06LifeCycle.class);
		//2.打印一条提示信息
		System.out.println("IOC 容器创建完成");
		
		//3.关闭IOC 容器
		((AbstractApplicationContext) applicationContext).close();
		
		/**
		 * 
		 * 执行的结果是这样的 ： 
		 * 	Car2 ... Contructor...
		 *	Car2 ...Initiaolize...
		 *	Car3 ... Constructor...
		 *	Car3 ... init...
		 *	Car ... Constructer...
		 *	Car ... Init...
		 *	IOC 容器创建完成
		 *	Car ... Destroy...
		 *	Car3 ... destroy...
		 *	Car2 ... Destroy...
		 */
	}

}
