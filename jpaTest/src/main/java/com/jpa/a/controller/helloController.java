package com.jpa.a.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		 System.out.println("idCheck");
		 return service.findByUserId(userId);
	 }
	 
	 @PostMapping("/join")
	 public String join( String userId, String password, String name) {
		 System.out.println("join");
		 member mem = service.nameCheck(name);
		 if(mem != null) {
			 return "nameError";
		 }else {
			 return service.join(userId, password, name);
		 } 
	 }
	 
	 @PostMapping("/login")
	 public String login( String userId , String password) {
		 
		  member mem = service.login(userId, password);
		  String a = "";
		  if(mem != null) {
			 
			  a = mem.getName();
		  }else {
			   a = "fail";
		  }
		  return a;
	 }
	 
	
	
	
    

}
