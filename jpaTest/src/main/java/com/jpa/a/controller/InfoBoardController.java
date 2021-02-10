package com.jpa.a.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import com.jpa.a.entity.InformationBoard;
import com.jpa.a.service.InfoBoardService;


@RestController
@RequestMapping("/infoBoard")
public class InfoBoardController {
	 
	@Autowired
	InfoBoardService infoBoardService;
		
	
	/*
	
	 @GetMapping("/insert") public InformationBoard insert() { 
		 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 return infoBoardRepository.save( new InformationBoard("석", "테스트중입니다13", "아 테스형~ 세상이 왜이래13", null, "info", wdate));
	 
	 }
	 */
	 
	 
	
	@GetMapping("/getList") public Map<String , Object> getList(@PageableDefault(size = 5, direction = Sort.Direction.DESC, sort = {"infoBoardSeq"}) Pageable pageRequest){
			
		List<InformationBoard> last = infoBoardService.findAll(pageRequest); 
		int page = infoBoardService.getTotalPageCount();
        Map<String , Object> map = new HashMap<String, Object>();
		
		map.put("list", last);
		map.put("totalPage", page);
		
		return map;
		
	}
//	
//	@GetMapping("/pageCount") public int pageCount(){
//			
//		int count = infoBoardService.pageCount();
//        
//		return count;
//		
//	}
	
	
	 @PostMapping("/write") public void write(String userName, String title, String conts, String image, String category) { 
		
		infoBoardService.write(userName, title, conts, image, category);
	
	 }
	 
    @PostMapping("/delete") public void delete(Long infoBoardSeq) { 
		 System.out.println("#################" + infoBoardSeq);
    	infoBoardService.delete(infoBoardSeq);
	 
	 }
 
    @PostMapping("/update") public void update(String infoBoardSeq, String title, String conts, String image, String category) { 
    	
    	infoBoardService.update(infoBoardSeq, title, conts, image, category);
    }
    
    @GetMapping("/detail") public InformationBoard infoBoardDetail(Long infoBoardSeq){
 	   System.out.println("hey");
 	   return infoBoardService.infoBoardDetail(infoBoardSeq);
    }
    
    @GetMapping("/next") public Long nextBoard(Long infoBoardSeq) {
		
		Long detail = infoBoardService.nextBoard(infoBoardSeq);
		
		return detail;
		
		
	}
	
}
