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
		//1.��ȡIOC����
		ApplicationContext applicationContext = 
					new AnnotationConfigApplicationContext(MainConfig01.class);
		//2.ͨ��IOC������ȡ����
		User user01 = (User) applicationContext.getBean("UserNorthCastle");
		//3.��ȡ�������������
		String names[] =  applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			logger.debug("#-->"+name);
		}
		//4.ʹ����־����������
		logger.debug(user01.toString());
		
	}

}
