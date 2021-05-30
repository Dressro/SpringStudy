package com.test.mytest.biz;

import com.test.mytest.dto.MemberDto;

public interface MemberBiz {

	public MemberDto login(MemberDto dto);

	public int insert(MemberDto dto);
}
