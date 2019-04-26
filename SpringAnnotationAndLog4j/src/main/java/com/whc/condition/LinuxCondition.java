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
		//1.��ȡBeanFactory
		ConfigurableBeanFactory beanFactory =  context.getBeanFactory();
		//2.��ȡ�������
		ClassLoader classLoader =  context.getClassLoader();
		//3.��ȡEnvironment��Ķ���
		Environment environment =  context.getEnvironment();
		
		String sysName = environment.getProperty("os.name");
		if (sysName.contains("Linux")) { // ���������windowʱ�򣬷���true
			return true;
		}
		return false;
	}

}
