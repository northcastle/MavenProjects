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
		//1.获取IOC容器
		ApplicationContext applicationContext 
					= new AnnotationConfigApplicationContext(MainConfig09Profiles.class);
		//2.查看所有的注册到容器中的bean
		String names[] = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	
	/**
	 * 下面的这种方式很方便的用来切换运行环境
	 */
	@Test
	public void testProfiles02(){
		//1.获取IOC容器 : AnnotationConfigApplicationContext :一定是个实现类的方式才能使使用具体的方法
		AnnotationConfigApplicationContext applicationContext 
				= new AnnotationConfigApplicationContext();
		//2.设置运行环境参数
		applicationContext.getEnvironment().setActiveProfiles("test");
		//3.注册配置类
		applicationContext.register(MainConfig09Profiles.class);
		//4.启动刷新容器
		applicationContext.refresh();
		
		//5.查看所有注册到容器中的bean
		String names[] = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		//6.既然拿到了数据库连接池，那么我就我就可以直接使用了:当然也是通过mybatis的方式
		//这里通过API的方式创建sqlSessionFactory,而不使用xml配置文件的方式
		//实际上和xml的方式是一样的，不过就是把所有的文件节点都换成了API的形式
		DataSource dataSource = (DataSource) applicationContext.getBean("testDataSource");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("test", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMappers("com.whc.mapper"); 
		// 这个地方绑定的应该是借口类的位置，
		// 目前来看，借口类需要和这个xml文件放在同一目录下面才可以使用，后期整合的时候一定要注意这个地方
		
		//7.下面的就是可以进行的常规操作了
		SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession session =  sessionFactory.openSession();
		UserMapper mapper =  session.getMapper(UserMapper.class);
		User user =  mapper.queryOneObject(1);
		System.out.println("到这里就查询完成了");
		System.out.println(user);
		System.out.println("到这里就打印完成了");
		
		 
		
	}

}
