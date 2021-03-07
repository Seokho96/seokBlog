package com.jpa.a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.EngWordWrongAnswer;

@Repository
public interface EngWrongAnswerRepository extends JpaRepository<EngWordWrongAnswer, Long>{

	
}
