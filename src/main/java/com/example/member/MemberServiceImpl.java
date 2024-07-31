package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao   dao;
	
	@Override
	public MemberVo getLogin(MemberVo vo) {
		return dao.getLogin(vo);
	}

}
