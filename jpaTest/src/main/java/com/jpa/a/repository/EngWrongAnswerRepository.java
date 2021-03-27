package com.jpa.a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.a.entity.EngWordWrongAnswer;

@Repository
public interface EngWrongAnswerRepository extends JpaRepository<EngWordWrongAnswer, Long>{

//	@Modifying
//	@Transactional
//	@Query("update EngWordWrongAnswer i set i.wrongTime = i.wrongTime + 1, i.lastWrongDate = :lastWrongDate where i.qSeq = :qSeq")
//	void updateWrong(@Param("qSeq") Long qSeq);
}
