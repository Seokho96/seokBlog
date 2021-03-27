package com.jpa.a.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.EngWordQuestion;
import com.jpa.a.entity.EngWordWrongAnswer;
import com.jpa.a.repository.EngWordQuetionRepository;
import com.jpa.a.repository.EngWordResultRepository;
import com.jpa.a.repository.EngWrongAnswerRepository;

@Service
public class EngWordService {

	@Autowired
	EngWordQuetionRepository engWordQuetionRepository;
	
	@Autowired
	EngWrongAnswerRepository engWrongAnswerRepository;
	
	@Autowired
	EngWordResultRepository engWordResultRepository;
	
	
	public void insertWord(EngWordQuestion param) throws ParseException {
	
		engWordQuetionRepository.save(param);
		// param.setCreDate(wdate);
		
//		List<EngWordQuestion> list = engWordQuetionRepository.findAll();
//		System.out.println(list.size());
//		EngWordWrongAnswer en = new EngWordWrongAnswer();
//		for (int i = 0; i < list.size(); i++) {
//			
//			en.setEngWordQuestion(typeRepo);
////			engWrongAnswerRepository.save(en);
//			
//			System.out.println(en.getEngWordQuestion());
//		}
	}
	
	public Map<String , Object> getWords(Pageable pageable) {
		Page<EngWordQuestion> paging = engWordQuetionRepository.findByDelDateIsNull(pageable);
		List<EngWordQuestion> list = paging.getContent();
		
		
	//	List<EngWordQuestion> total = engWordQuetionRepository.findByDelDateIsNull();
		Long totalPage = engWordQuetionRepository.engWordQuestionCount();
		System.out.println(totalPage);
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("wordList", list);
		map.put("totalPage", totalPage);
		return map;
	}
	
	public List<EngWordQuestion> getTestQuestion(){
		List<EngWordQuestion> list = engWordQuetionRepository.getTestQuestion();
		//List<EngWordQuestion> list = paging.getContent();
		return list.subList(0, 30);
	}
	
//	public void updateWrong(String qSeq) {
//		engWrongAnswerRepository.updateWrong(Long.parseLong(qSeq));
//	}
	
	
}
