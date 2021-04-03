package com.jpa.a.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.a.entity.EngWordQuestion;
import com.jpa.a.entity.InformationBoard;



@Repository
public interface EngWordQuetionRepository extends JpaRepository<EngWordQuestion, Long>{

	Page<EngWordQuestion> findAllByDelDateIsNullAndWord(String word, Pageable pageable);
	
	Page<EngWordQuestion> findAllByDelDateIsNullAndTranslateLike(String word, Pageable pageable);
	
	Page<EngWordQuestion> findByDelDateIsNull(Pageable pageable);
//	Page<EngWordQuestion> findByDelDateIsNullOrderByRand(Pageable pageable);
	
	List<EngWordQuestion> findByDelDateIsNull();
	
	
	  @Query("select i from EngWordQuestion i where i.delDate is null order by rand()") 
	  List<EngWordQuestion> getTestQuestion();
	
	@Query("select count(i.qSeq) from EngWordQuestion i where i.delDate is null")
	Long engWordQuestionCount();
	
	@Query("select count(i.qSeq) from EngWordQuestion i where i.delDate is null and i.word = :word or i.translate like %:word%")
	Long engWordSearchQuestionCount(@Param("word") String searchWord);
	


	
}
