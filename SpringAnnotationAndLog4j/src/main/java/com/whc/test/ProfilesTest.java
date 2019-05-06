package com.whc.test;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.glass.ui.Application;
import com.whc.config.MainConfig09Profiles;
import com.whc.mapper.UserMapper;
import com.whc.model.User;

public class ProfilesTest {
	
	@Test
	public void testProfiles01(){
		//1.��ȡIOC����
		ApplicationContext applicationContext 
					= new AnnotationConfigApplicationContext(MainConfig09Profiles.class);
		//2.�鿴���е�ע�ᵽ�����е�bean
		String names[] = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	
	/**
	 * ��������ַ�ʽ�ܷ���������л����л���
	 */
	@Test
	public void testProfiles02(){
		//1.��ȡIOC���� : AnnotationConfigApplicationContext :һ���Ǹ�ʵ����ķ�ʽ����ʹʹ�þ���ķ���
		AnnotationConfigApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext();
		//2.�������л�������
		applicationContext.getEnvironment().setActiveProfiles("test");
		//3.ע��������
		applicationContext.register(MainConfig09Profiles.class);
		//4.����ˢ������
		applicationContext.refresh();
		
		//5.�鿴����ע�ᵽ�����е�bean
		String names[] = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		//6.��Ȼ�õ������ݿ����ӳأ���ô�Ҿ��ҾͿ���ֱ��ʹ����:��ȻҲ��ͨ��mybatis�ķ�ʽ
		//����ͨ��API�ķ�ʽ����sqlSessionFactory,����ʹ��xml�����ļ��ķ�ʽ
		//ʵ���Ϻ�xml�ķ�ʽ��һ���ģ��������ǰ����е��ļ��ڵ㶼������API����ʽ
		DataSource dataSource = (DataSource) applicationContext.getBean("testDataSource");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("test", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMappers("com.whc.mapper"); 
		// ����ط��󶨵�Ӧ���ǽ�����λ�ã�
		// Ŀǰ�������������Ҫ�����xml�ļ�����ͬһĿ¼����ſ���ʹ�ã��������ϵ�ʱ��һ��Ҫע������ط�
		
		//7.����ľ��ǿ��Խ��еĳ��������
		SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession session =  sessionFactory.openSession();
		UserMapper mapper =  session.getMapper(UserMapper.class);
		User user =  mapper.queryOneObject(1);
		System.out.println("������Ͳ�ѯ�����");
		System.out.println(user);
		System.out.println("������ʹ�ӡ�����");
		
		 
		
	}

}
