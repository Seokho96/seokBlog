package com.jpa.a.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.a.entity.InformationBoard;
import com.jpa.a.repository.InfoBoardRepository;

@Service
public class InfoBoardService {

	@Autowired
	InfoBoardRepository infoBoardRepository;
	
  public List<InformationBoard> findAll(Pageable pageable){
	  
	    Page<InformationBoard> list = infoBoardRepository.findByDelDateIsNull(pageable); 
		
		List<InformationBoard> last = list.getContent();
	   
		for (int i = 0; i < last.size(); i++) {
			last.get(i).setConts(last.get(i).getConts().replace("<br/>", ""));
		}
		
	  return last;
  }
  public int getTotalPageCount() {
	  List<InformationBoard> totalPage = infoBoardRepository.findByDelDateIsNull();
	  int tp = totalPage.size();
	  return tp;		  
  }
	
	
   public InformationBoard infoBoardDetail(Long infoBoardSeq){
	   
	   InformationBoard detail =  infoBoardRepository.infoBoardDetail(infoBoardSeq).get(0);
	   
	   return detail;
   }
   
//   public int pageCount(){
//		
//		List<InformationBoard> list = infoBoardRepository.findAll();
//       
//		int count = list.size();
//		
//		return count;
//		
//	}
   
   public void delete(Long infoBoardSeq) { 
	     SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy. MM. dd. HH:mm");
		 Date date = new Date();
		 String delDate = format2.format(date);
		 
		infoBoardRepository.deleteInfo(infoBoardSeq, delDate);
	 
	 }
	
   public void write(String userName, String title, String conts, String image, String category) { 
	   
		 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy. MM. dd. HH:mm");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 
		 infoBoardRepository.save( new InformationBoard(userName, title, conts, image, category, wdate));
	 
	 }
	
   
	public void update(String infoBoardSeq, String title, String conts, String image, String category) { 
    	
   	 SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
		 Date date = new Date();
		 String wdate = format2.format(date);
		 
   	infoBoardRepository.updateInfo(Long.parseLong(infoBoardSeq), title, conts, image, wdate);
   }
	
	public Long nextBoard(Long infoBoardSeq) {
		
		InformationBoard detail = infoBoardRepository.findTop1ByInfoBoardSeqGreaterThanOrderByInfoBoardSeqAsc(infoBoardSeq).get(0);
		
		Long Seq = detail.getInfoBoardSeq();
		
		return Seq;
		
		
	}
}
