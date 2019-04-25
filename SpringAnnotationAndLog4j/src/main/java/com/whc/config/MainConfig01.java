package com.whc.config;

import static org.junit.Assert.assertFalse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.whc.model.User;
import com.whc.service.imple.UserServiceImpl;

/**
 * @Configuration : 此注解用来标识 这个类是一个配置 类
 * @ComponentScan():此注解用来配置自动扫描组件
 * 			(1).value : 制定要扫描的包名，包括下面的子包
 * 			(2).excludeFilters={ // 不扫描哪些包
					@Filter(type=FilterType.ANNOTATION,classes={Service.class,Controller.class})
				},
			(3).includeFilters={ // 知名要扫描哪些包：前提是需要把默认扫描给关闭掉
					@Filter(type=FilterType.ANNOTATION,classes={Controller.class}), // 使用注解过滤
					@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={UserServiceImpl.class}), // 使用类进行过滤
					@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class}) //使用自定义的过滤器进行扫描
				},
			useDefaultFilters = false // 写了这个includeFilters才会生效,使用过滤器，默认情况下的是true，
 * @author northcastle
 *
 */
@Configuration
@ComponentScan(value="com.whc",
//			excludeFilters={ // 不扫描哪些包
//					@Filter(type=FilterType.ANNOTATION,classes={Service.class,Controller.class})
//			}
			includeFilters={ // 知名要扫描哪些包：前提是需要把默认扫描给关闭掉
					//@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
					//@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={UserServiceImpl.class}),
					@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
			},
			useDefaultFilters = false // 写了这个includeFilters才会生效
			
)
public class MainConfig01 {
	/**
	 * @Bean : 此注解用来给IOC容器 注册一个Bean对象，相对于之前的配置文件，作用是一样的
	 * 	类型为返回值类型；
	 *  id默认为方法名，但是如果括号中写了，那么就是用括号中的值
	 * @return
	 */
	@Bean("UserNorthCastle")
	public User user01(){
		return new User("王宏昌", 18);
	}

}
