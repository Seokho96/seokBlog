package com.jpa.a.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "infoBoard")
public class InformationBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long infoBoardSeq;
	
	@NonNull
	@Column(name = "userName", nullable = false, updatable = false)
	private String userName;
	
	@NonNull
	@Column(name = "title", nullable = false, updatable = true)
	private String title;
	 
	@NonNull
	@Column(name = "conts", nullable = false, updatable = true)
	private String conts;
	
	@Column(name = "image", nullable = true, updatable = true)
	private String image;  
	
	@Column(name = "wdate", nullable = false, updatable = true)
	private String wdate;
	
	@Column(name ="del_date", nullable = true, updatable = true)
	private String delDate;
	
	@Column(name = "category", nullable = false, updatable = true)
	private String category;
	
	public InformationBoard(String userName, String title, String conts, String image, String category, String wdate) {
		this.userName= userName;
		this.title = title;
		this.conts = conts;
		this.image = image;
		this.category = category;
		this.wdate = wdate;
	}


}
