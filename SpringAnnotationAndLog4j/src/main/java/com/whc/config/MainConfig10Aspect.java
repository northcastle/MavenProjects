package com.whc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//启用基于注解的aop模式
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages={"com.whc.aop"})
public class MainConfig10Aspect {
	//组件都使用注解的方式添加到了这个配置类中
}
