package com.test.mytest.dao;

import java.util.List;

import com.test.mytest.dto.MyBoardDto;

public interface MyBoardDao {

	String NAMESPACE = "test.";
	
	public List<MyBoardDto> selectList();
	
	public MyBoardDto selectOne(int myno);
	
	public int insert(MyBoardDto dto);
	
	public int update(MyBoardDto dto);
	
	public int delete(int myno);
	
}
