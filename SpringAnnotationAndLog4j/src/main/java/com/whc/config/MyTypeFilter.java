package com.whc.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;

public class MyTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//1.获取注解
		AnnotationMetadata annotationMetadata =  metadataReader.getAnnotationMetadata();
		//2.获取类
		ClassMetadata classMetadata =  metadataReader.getClassMetadata();
		//3.获取资源
		Resource resource =  metadataReader.getResource();
		
		System.out.println(annotationMetadata.getClassName());
		System.out.println(classMetadata.getClassName());
		System.out.println(resource);
		System.out.println("==============================");
		
		//4.当资源获取到的时候，就可以进行规则的定制了：
		if(classMetadata.getClassName().equals("com.whc.controller.UserController")){ // 这就是个字符串的操作
			return true;
		}
		
		return false;
	}

}
