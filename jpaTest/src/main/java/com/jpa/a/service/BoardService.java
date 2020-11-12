package com.jpa.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.Board;
import com.jpa.a.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> getList() {
		return boardRepository.findAll();
	}
}
