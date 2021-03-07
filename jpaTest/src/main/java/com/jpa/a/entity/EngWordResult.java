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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Eng_word_result")
public class EngWordResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aSeq;
	
	@Column(name = "correctNumber", nullable = true, updatable = true)
	private int correctNumber;

	@Column(name = "wrongNumber", nullable = true, updatable = true)
	private int wrongNumber;

	@Column(name = "creDate", nullable = true, updatable = true)
	private Timestamp creDate;
}
