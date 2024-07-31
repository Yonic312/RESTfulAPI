package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.member.MemberService;
import com.example.member.MemberVo;

@Service
public class SecurityUserDetailsService implements UserDetailsService  {
	
	SecurityUserDetailsService(){
		System.out.println("==>SecurityUserDetailsService");
	}
	
	@Autowired
	MemberService service;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo vo = new MemberVo();
		System.out.println("username확인:" + username);
		vo.setUsername(username);
		
		MemberVo user = service.getLogin(vo);
		if (user == null) {
			throw  new UsernameNotFoundException(username + "사용자 없음");
		}else {
			return new SecurityUser(user);
		}
	}

}