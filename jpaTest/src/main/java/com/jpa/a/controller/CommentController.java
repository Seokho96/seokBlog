package com.jpa.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.a.entity.Comment;
import com.jpa.a.entity.member;
import com.jpa.a.repository.CommentRepository;
import com.jpa.a.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentRepository commentRepository;
	
	
	
	@GetMapping("/getList")
	public List<Comment> getList(HttpSession session, HttpServletRequest request) {
		  System.out.print("commentList");
		 return commentService.getList();
	}
	
	
	  @PostMapping("/write") public String writeComment(String conts, HttpServletRequest request) {
	      member mem =  (member)request.getSession().getAttribute("s_Kg234");
	      if(mem == null) {
	    	 String ab = "loginFalse";
	    	 
	    	 return ab;
	      }
	      String userName =  mem.getName();
	      
	      String a = commentService.writeComment(conts, userName);
	      
	      return a;
	      
	 }
	 

}
