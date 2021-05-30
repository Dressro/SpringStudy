package com.test.mytest.dao;

import com.test.mytest.dto.MemberDto;

public interface MemberDao {

	String NAMESPACE = "member.";

	public MemberDto login(MemberDto dto);

	public int insert(MemberDto dto);
}
