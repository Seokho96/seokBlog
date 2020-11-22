package com.jpa.a.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.InformationBoard;


@Repository
public interface InfoBoardRepository extends JpaRepository<InformationBoard, Long> {
	
	
	Page<InformationBoard> findAll(Pageable pageable);
		
	@Query("delete from InformationBoard c where c.InfoBoardSeq = :InfoBoardSeq")
	void deleteInfo(@Param("InfoBoardSeq") Long InfoBoardSeq);
	
	@Query("update InformationBoard c set c.title= :title, c.conts = :conts, c.image = :image, c.wdate = :wdate where c.InfoBoardSeq = :InfoBoardSeq")
	void updateInfo(@Param("InfoBoardSeq") Long InfoBoardSeq, @Param("title") String title, @Param("conts") String conts, @Param("image") String image, @Param("wdate") String wdate);

}
