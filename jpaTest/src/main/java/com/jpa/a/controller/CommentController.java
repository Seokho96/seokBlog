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
	public List<Comment> getList() {
		
		  System.out.print("commentList");
		 return commentService.getList();
	}
	
	
	  @PostMapping("/write") public String writeComment(String conts, String name) {
	      
	    
	      String userName =  name;
	      
	      String a = commentService.writeComment(conts, userName);
	      
	      return a;
	      
	 }
	  
	  @PostMapping("/delete") public String deleteComment(Long commentSeq, String userName) {
	         
	      String a = commentService.deleteComment(commentSeq, userName);
	      
	      return a;
	      
	 }
	  
	  
	 

}
