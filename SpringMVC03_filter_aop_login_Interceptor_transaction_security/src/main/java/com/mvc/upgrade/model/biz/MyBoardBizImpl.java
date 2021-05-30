package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MyBoardDao;
import com.mvc.upgrade.model.dto.MyBoardDto;

@Service
public class MyBoardBizImpl implements MyBoardBiz {

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

	@Transactional
	@Override
	public String test() {
		// TODO Auto-generated method stub
		dao.insert(new MyBoardDto(0, "transaction", "test", "insert", null));
		
		String test = dao.test();
		test.length();
		
		return test;
	}

}
