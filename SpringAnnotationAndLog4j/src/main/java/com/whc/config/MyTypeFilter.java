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
		//1.��ȡע��
		AnnotationMetadata annotationMetadata =  metadataReader.getAnnotationMetadata();
		//2.��ȡ��
		ClassMetadata classMetadata =  metadataReader.getClassMetadata();
		//3.��ȡ��Դ
		Resource resource =  metadataReader.getResource();
		
		System.out.println(annotationMetadata.getClassName());
		System.out.println(classMetadata.getClassName());
		System.out.println(resource);
		System.out.println("==============================");
		
		//4.����Դ��ȡ����ʱ�򣬾Ϳ��Խ��й���Ķ����ˣ�
		if(classMetadata.getClassName().equals("com.whc.controller.UserController")){ // ����Ǹ��ַ����Ĳ���
			return true;
		}
		
		return false;
	}

}
