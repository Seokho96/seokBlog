package com.jpa.a.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.Comment;
import com.jpa.a.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> getList(){
		Sort sort = sortBycommentSeq();
		
		final List<Comment> list = commentRepository.findAll(sort);
		
		return list;
	}
	
	private Sort sortBycommentSeq() {
		return Sort.by(Sort.Direction.DESC, "commentSeq");
	}
	
	public String writeComment( String conts , String userName ) {
		 List<Comment> list = (List<Comment>)commentRepository.findByUserName(userName);
		String a = "";
		if(list.size() != 0) {
			a = "alreadyWrite";
		}else {
		  commentRepository.save(new Comment(userName, conts, new Date()));
		  a = "success";
		}
		return a;
		
	}
	
	public String deleteComment (Long commentSeq, String userName) {
		
		String a = "";
		 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy. MM. dd. HH:mm");
		 Date date = new Date();
		 String delDate = format2.format(date);
		
	try {
		commentRepository.deleteComment(commentSeq, userName, delDate);
	} catch (Exception e) {
		a = "fail";
	}
	finally {
		a = "success";
	}
	       return a;
	}

}
