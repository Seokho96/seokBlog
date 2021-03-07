package com.jpa.a.entity;

import java.sql.Timestamp;
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
@Table(name = "Eng_word_question")
public class EngWordQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qSeq;
	
	@NonNull
	@Column(name = "word", nullable = false, updatable = true)
	private String word;
	 
	@NonNull
	@Column(name = "translate", nullable = false, updatable = true)
	private String translate;

	@Column(name = "creDate", nullable = true, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creDate;
	
	@Column(name = "delDate", nullable = true, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp delDate;
	
	

}
