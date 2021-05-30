package com.test.mytest.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mytest.dto.MyBoardDto;

@Repository
public class MyBoardDaoImpl implements MyBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyBoardDto> selectList() {
		// TODO Auto-generated method stub
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		MyBoardDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
