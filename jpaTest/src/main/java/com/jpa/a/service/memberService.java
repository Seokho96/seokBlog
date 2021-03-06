package com.jpa.a.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.member;
import com.jpa.a.repository.MemberRepository;

@Service
public class memberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	
	public String findByUserId( String userId) {
		
		List<member> list = memberRepository.findByUserId(userId);
		String a = "";
		if(list.isEmpty()) {
			a = "true";
		}else {
			a = "false";
		}
		
		return a;
	}
	
	public String join( String userId, String password, String name) {
		//String pwd = bCryptPasswordEncoder.encode(password);
		member mem = memberRepository.save(new member(userId, password, name, "ROLE_USER",0));
		
		 String a = "";
		 if(mem.getUserId() == null) {
			 a = "false";
		 }
		 else {
			 a = "true";
		 }
		 return a;
	}
	
	public member login( String userId, String password) {
	
		return memberRepository.findMember(userId, password);
	}
	
	public member nameCheck( String name) {
		return memberRepository.nameCheck(name); 
	}

}
