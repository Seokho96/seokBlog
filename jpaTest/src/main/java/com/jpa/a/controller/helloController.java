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
	   return service.join(userId, password, name);
	 }
	 
	 @PostMapping("/login")
	 public String login( String userId , String password, HttpServletRequest request, HttpSession session ) {
		 
		  member mem = service.login(userId, password);
		  String a = "";
		  if(mem != null) {
			  session.setAttribute("s_Kg234", mem);
			  a = "success";
		  }else {
			   a = "fail";
		  }
		  return a;
	 }
	 
	 @GetMapping("/loginCheck")
	 public String loginCheck(HttpServletRequest request) {
		member mem =  (member)request.getSession().getAttribute("s_Kg234");
		String userName = "";
		if(mem != null) {
			 userName =  mem.getName();
		}else {
			userName = "";
		}
		
		 return userName;
	 }
	 
	 @PostMapping("/logout")
	 public void logout(HttpSession session) {
		 session.removeAttribute("s_Kg234");
	 }
	
	
    

}
