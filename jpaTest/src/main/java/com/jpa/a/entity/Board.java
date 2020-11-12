package com.jpa.a.entity;



import java.util.Date;

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
@Table(name = "board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borderSeq;
	
	@NonNull
	@Column(name = "userSeq", nullable = false, updatable = false)
	private Long seq;
	
	@NonNull
	@Column(name = "title", nullable = false, updatable = true)
	private String title;
	 
	@NonNull
	@Column(name = "conts", nullable = false, updatable = true)
	private String conts;
	
	@Column(name = "image", nullable = true, updatable = true)
	private String image;  
	
	@Column(name = "wdate", nullable = false, updatable = true)
	private Date wdate;
	
	@Column(name = "category", nullable = false, updatable = true)
	private String category;
	
	public Board(Long seq, String title, String conts, String image, String category, Date wdate) {
		this.seq= seq;
		this.title = title;
		this.conts = conts;
		this.image = image;
		this.category = category;
		this.wdate = wdate;
	}

}
