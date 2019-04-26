package com.whc.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		//1.获取BeanFactory
		ConfigurableBeanFactory beanFactory =  context.getBeanFactory();
		//2.获取类加载器
		ClassLoader classLoader =  context.getClassLoader();
		//3.获取Environment类的对象
		Environment environment =  context.getEnvironment();
		
		String sysName = environment.getProperty("os.name");
		if (sysName.contains("Linux")) { // 当这个包含window时候，返回true
			return true;
		}
		return false;
	}

}
