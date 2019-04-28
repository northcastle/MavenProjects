package com.whc.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.whc.model.Blue;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, 
										BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
//		String[] names =  registry.getBeanDefinitionNames();
//		for (String name : names) {
//			System.out.println("reg--->"+name);
//		}
		
		//创建一个注册参数
		BeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
		//自己注册一个bean
		registry.registerBeanDefinition("blue", beanDefinition);

	}

}
