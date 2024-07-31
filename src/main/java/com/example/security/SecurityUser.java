package com.example.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.member.MemberVo;

public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;

	public SecurityUser( MemberVo vo ) {
		super(vo.getUsername(), 
			  "{noop}" + vo.getPassword(), 
			  AuthorityUtils.createAuthorityList(vo.getRole().toString()));
  	}	

}