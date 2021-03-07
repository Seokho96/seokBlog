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
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentSeq;
	
	@NonNull
	@Column(name = "userName", nullable = false, updatable = false)
	private String userName;
	 
	@NonNull
	@Column(name = "conts", nullable = false, updatable = true)
	private String conts;

	@Column(name = "wdate", nullable = false, updatable = true)
	private Date wdate;
	
	@Column(name = "delDate", nullable = false, updatable = true)
	private Date delDate;
	
	
	public Comment(String userName, String conts, Date wdate) {
		this.userName= userName;		
		this.conts = conts;
		this.wdate = wdate;
	}
	
	public Comment(String conts) {
		this.conts = conts;
	}


}
