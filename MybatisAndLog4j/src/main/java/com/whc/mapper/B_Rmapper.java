package com.whc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whc.model.Usera;

public interface B_Rmapper {
	
	//1.���ݲ�����ѯһ������
	public Usera queryOne(@Param("id") int id);
	
	//2.���ݲ�����ѯһ������ �� ����Ҫѧϰ���ǰ� ����Ҳ����ȥ��Ϊ������ƴ������ ${} ��ʹ��
	public Usera queryOne2(@Param("id") int id,@Param("tableName") String tableName);
		
	//3.ʹ��resultMap ���в�ѯһ������,resultMap�ǳ���ǿ��
	public Usera queryOne3(@Param("id")int id);
	
	//4.���ݲ�����ѯһ�����
	public List<Usera> queryForList1(@Param("id") int id);
	
	//5.���ݲ�����ѯһ�����
	public List<Usera> queryForList2(@Param("ids") int[] ids);
	
	//6.ʹ��resultMap��ѯһ����� �� ����classid���в�ѯ�Ĳ���
	public List<Usera> queryForList3(@Param("cid") int cid);
	
	

}
