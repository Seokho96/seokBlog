package com.jpa.a.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Eng_word_wrong_answer")
public class EngWordWrongAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wASeq;
	
	@ManyToOne
    @JoinColumn(name = "qSeq", referencedColumnName ="qSeq")
	private EngWordQuestion engWordQuestion;
	 
	
	@Column(name = "wrongTime", nullable = true, updatable = true)
	private int wrongTime;

	@Column(name = "creDate", nullable = true, updatable = true)
	private Timestamp creDate;
	
	@Column(name = "lastWrongDate", nullable = true, updatable = true)
	private Timestamp lastWrongDate;
}
