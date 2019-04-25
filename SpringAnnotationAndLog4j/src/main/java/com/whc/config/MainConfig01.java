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
 * @Configuration : ��ע��������ʶ �������һ������ ��
 * @ComponentScan():��ע�����������Զ�ɨ�����
 * 			(1).value : �ƶ�Ҫɨ��İ���������������Ӱ�
 * 			(2).excludeFilters={ // ��ɨ����Щ��
					@Filter(type=FilterType.ANNOTATION,classes={Service.class,Controller.class})
				},
			(3).includeFilters={ // ֪��Ҫɨ����Щ����ǰ������Ҫ��Ĭ��ɨ����رյ�
					@Filter(type=FilterType.ANNOTATION,classes={Controller.class}), // ʹ��ע�����
					@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={UserServiceImpl.class}), // ʹ������й���
					@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class}) //ʹ���Զ���Ĺ���������ɨ��
				},
			useDefaultFilters = false // д�����includeFilters�Ż���Ч,ʹ�ù�������Ĭ������µ���true��
 * @author northcastle
 *
 */
@Configuration
@ComponentScan(value="com.whc",
//			excludeFilters={ // ��ɨ����Щ��
//					@Filter(type=FilterType.ANNOTATION,classes={Service.class,Controller.class})
//			}
			includeFilters={ // ֪��Ҫɨ����Щ����ǰ������Ҫ��Ĭ��ɨ����رյ�
					//@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
					//@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={UserServiceImpl.class}),
					@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
			},
			useDefaultFilters = false // д�����includeFilters�Ż���Ч
			
)
public class MainConfig01 {
	/**
	 * @Bean : ��ע��������IOC���� ע��һ��Bean���������֮ǰ�������ļ���������һ����
	 * 	����Ϊ����ֵ���ͣ�
	 *  idĬ��Ϊ���������������������д�ˣ���ô�����������е�ֵ
	 * @return
	 */
	@Bean("UserNorthCastle")
	public User user01(){
		return new User("�����", 18);
	}

}
