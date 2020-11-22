package com.jpa.a.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationBoardDto {
   
	
	private Long InfoBoardSeq;
	private String userName;
	private String title;
	private String conts;
	private String image;  
	private String wdate;
	private String category;
	
	
}
