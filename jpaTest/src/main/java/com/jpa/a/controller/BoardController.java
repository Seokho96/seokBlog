package com.jpa.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.a.entity.Board;
import com.jpa.a.entity.Comment;
import com.jpa.a.repository.BoardRepository;
import com.jpa.a.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	BoardRepository boardRepository;
	
	/*
	 * @GetMapping("/insert") public Board insert() { return
	 * boardRepository.save(new Board((long) 1, "Paper House",
	 * "* Paper House는 작가의 꿈을 가진 남녀노소 누구나 자신의 글을 집필하고 ‘신인 작가’로서 데뷔할 수 있는 플랫폼입니다.",
	 * "IU2.gif", "project", new Date())); }
	 */
	
	
	@GetMapping("/getList")
	public List<Board> getList(String category){
       System.out.print(category);
		return service.getList(category);
	}
	
	@GetMapping("/getMiniList")
	public List<Board> getMiniList(String category){

		return service.getMini(category);
	}
	

}
