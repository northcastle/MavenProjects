package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.whc.model.User;

public class MainConfig02 {

	/**
	 * Ĭ������£�bean�ǵ�ʵ����
	 * ��1����ʵ���������(singleton)����IOC ��������ʱ�ͻ���÷�����������
	 * 					�Ժ�ÿ�λ�ȡ��ֱ�Ӵ���������ȥ���󣬹�ÿ����ȥ�Ķ�����ͬһ��
	 * ��2����ʵ���������(prototype)������ȡbean��ʱ��Żᴴ������
	 * 					�Ժ�ÿ�λ�ȡ�����´���һ�����󣬹�ÿ����ȥ�Ķ�����һ���µĵĶ���
	 * @return
	 */
	@Scope("prototype")
	@Bean("user")
	public User user() {
		System.out.println("User ��������");
		return new User("����", 22);
	}
	/**
	 *  ������(lazy) : ר����Ե�ʵ���Ķ���
	 *  	��ʵ��bean : Ĭ�����IOC����������ʱ�򴴽�����
	 *  	������ �� �������������������ڵ�һ��ʹ�ö����ǣ��������󣬲���ʼ��
	 * @return
	 */
	@Lazy
	@Bean("user02")
	public User user02() {
		System.out.println("User02 ��������");
		return new User("����", 22);
	}
}
