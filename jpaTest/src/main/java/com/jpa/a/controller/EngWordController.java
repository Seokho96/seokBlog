package com.jpa.a.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jpa.a.entity.EngWordQuestion;
import com.jpa.a.service.EngWordService;

@RestController
@RequestMapping("/hidden")
public class EngWordController {
	
	@Autowired
	EngWordService engWordService;
	
	@GetMapping("/getWords")
	public Map<String , Object> getWords(@PageableDefault(size = 5, direction = Sort.Direction.DESC, sort = {"qSeq"}) Pageable pageRequest) {
		
		Map<String , Object> map = engWordService.getWords(pageRequest);
		
		// Map<String , Object> map = new HashMap<String, Object>();
		 
		// map.put("wordList", list);
		 
		 return map;
	}
	
	
	@PostMapping("/insertWord")
	public void insertWord(@RequestBody EngWordQuestion param) throws ParseException {
	
		  System.out.println(param.toString());
			engWordService.insertWord(param);
	}

}
