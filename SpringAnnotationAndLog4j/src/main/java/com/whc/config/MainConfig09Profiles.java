package com.whc.config;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@PropertySource("classpath:/applicationContext.properties")
@Configuration
public class MainConfig09Profiles {
	
	@Autowired
	private Environment env;
	
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource testDataSource(){
		
		//这个数据库连接池是mybatis的连接池
		PooledDataSource dataSource = new PooledDataSource();
		
		String driver = env.getProperty("spring.whc.test.db.driver");
		String url = env.getProperty("spring.whc.test.db.url");
		String username = env.getProperty("spring.whc.test.db.user");
		String password = env.getProperty("spring.whc.test.db.password");
		
		System.out.println("test : "+driver+" --> "+url+" --> "+username+" --> "+password);
		
		dataSource.setDriver(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource devDataSource(){
		
		PooledDataSource dataSource = new PooledDataSource();
		
		String driver = env.getProperty("spring.whc.dev.db.driver");
		String url = env.getProperty("spring.whc.dev.db.url");
		String username = env.getProperty("spring.whc.dev.db.user");
		String password = env.getProperty("spring.whc.dev.db.password");
		
		System.out.println("dev : "+driver+" --> "+url+" --> "+username+" --> "+password);
		
		dataSource.setDriver(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	

}
