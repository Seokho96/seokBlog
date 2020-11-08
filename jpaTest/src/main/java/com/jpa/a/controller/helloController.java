package com.jpa.a.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.a.entity.member;
import com.jpa.a.repository.MemberRepository;
import com.jpa.a.service.memberService;


@RestController
@RequestMapping("/user")
public class helloController {
	
	@Autowired
	private memberService service;
	
	@Autowired
	private MemberRepository memberRepository;
	
	/*
	
	 @GetMapping("/insert") // CREATE
	    public member insert(){
	        return memberRepository.save(
	               new member("seok", "a", "석", "ROLE_ADMIN",1)
	        );
	    }
	    */
	 
	 @GetMapping("/idCheck")
	 public String idCheck( String userId) {
		 
		 return service.findByUserId(userId);
	 }
	 
	 @PostMapping("/join")
	 public String join( String userId, String password, String name) {
		 
	   return service.join(userId, password, name);
	 }
	
	
    

}
