package com.whc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//���û���ע���aopģʽ
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages={"com.whc.aop"})
public class MainConfig10Aspect {
	//�����ʹ��ע��ķ�ʽ��ӵ��������������
}
