package com.example.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
	MemberVo	getLogin(MemberVo  vo);
}
