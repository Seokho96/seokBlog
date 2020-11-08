package com.jpa.a.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.member;
import com.jpa.a.repository.MemberRepository;

@Service
public class memberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
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
		
		member mem = memberRepository.save(new member(userId, password, name, "ROLE_USER",0));
		
		 String a = "";
		 if(mem.getUserId() == null) {
			 a = "true";
		 }
		 else {
			 a = "false";
		 }
		 return a;
	}

}
