package com.whc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.whc.model.User;

@Mapper
public interface UserMapper {
	//1.��װ����һ������
	public User queryOneObject(@Param("id") int id);
}
