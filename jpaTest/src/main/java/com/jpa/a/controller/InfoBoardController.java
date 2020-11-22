package com.jpa.a.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.a.dto.InformationBoardDto;
import com.jpa.a.entity.InformationBoard;
import com.jpa.a.repository.InfoBoardRepository;


@RestController
@RequestMapping("/infoBoard")
public class InfoBoardController {
	 
	@Autowired
	InfoBoardRepository infoBoardRepository;
	
	
	
	 
	 @GetMapping("/insert") public InformationBoard insert() { 
		 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 return infoBoardRepository.save( new InformationBoard("석", "테스트중입니다3", "아 테스형~ 세상이 왜이래3", null, "info", wdate));
	 
	 }
	 
	
	@GetMapping("/getList") public List<InformationBoard> getList(@PageableDefault(size = 10) Pageable pageRequest){
			
		System.out.println("getList");
		Page<InformationBoard> list = infoBoardRepository.findAll(pageRequest); 
		
		List<InformationBoard> last = list.getContent();

		return last;
		
	}
	
	 @PostMapping("/write") public InformationBoard write(String userName, String title, String conts, String image, String category) { 
		 
		 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 
		 return infoBoardRepository.save( new InformationBoard(userName, title, conts, image, category, wdate));
	 
	 }
	 
    @PostMapping("/delete") public void delete(String infoBoardSeq) { 
		 
		infoBoardRepository.deleteInfo(Long.parseLong(infoBoardSeq));
	 
	 }
 
    @PostMapping("/update") public void update(String infoBoardSeq, String title, String conts, String image, String category) { 
    	
    	 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 
    	infoBoardRepository.updateInfo(Long.parseLong(infoBoardSeq), title, conts, image, wdate);
    }
	
}
