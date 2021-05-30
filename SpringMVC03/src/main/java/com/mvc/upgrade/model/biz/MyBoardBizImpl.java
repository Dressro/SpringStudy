package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MyBoardDao;
import com.mvc.upgrade.model.dto.MyBoardDto;

@Service
public class MyBoardBizImpl implements MyBoardBiz {

	// @Respository 컨퍼너트 어노테이션을 상속 받음
	// 컨퍼넌트 어노테이션 -> 객체를 만들어 줌
	@Autowired
	private MyBoardDao dao;
	
	@Override
	public List<MyBoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return dao.delete(myno);
	}

}
