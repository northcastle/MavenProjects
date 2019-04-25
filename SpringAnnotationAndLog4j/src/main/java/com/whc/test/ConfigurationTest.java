package com.whc.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whc.config.MainConfig01;
import com.whc.model.User;

public class ConfigurationTest {
	
	public static Logger logger = Logger.getLogger(ConfigurationTest.class);
	
	@Test
	public void testConfiguration(){
		//1.获取IOC容器
		ApplicationContext applicationContext = 
					new AnnotationConfigApplicationContext(MainConfig01.class);
		//2.通过IOC容器获取对象
		User user01 = (User) applicationContext.getBean("UserNorthCastle");
		//3.获取所有组件的名字
		String names[] =  applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			logger.debug("#-->"+name);
		}
		//4.使用日志输出这个对象
		logger.debug(user01.toString());
		
	}

}
