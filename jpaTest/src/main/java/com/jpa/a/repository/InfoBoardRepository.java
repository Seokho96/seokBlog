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

import com.jpa.a.entity.InformationBoard;


@Repository
public interface InfoBoardRepository extends JpaRepository<InformationBoard, Long> {
	
	List<InformationBoard> findTop1ByInfoBoardSeqGreaterThanOrderByInfoBoardSeqAsc(Long infoBoardSeq);
	
	List<InformationBoard> findByDelDateIsNull();
	
	Page<InformationBoard> findByDelDateIsNull(Pageable pageable);


	@Query("select i from InformationBoard i where i.infoBoardSeq = :infoBoardSeq")
	List<InformationBoard> infoBoardDetail(@Param("infoBoardSeq") Long infoBoardSeq);
	
	@Modifying
	@Transactional
	@Query("update InformationBoard c set c.delDate = :delDate where c.infoBoardSeq = :infoBoardSeq")
	void deleteInfo(@Param("infoBoardSeq") Long infoBoardSeq, @Param("delDate")String delDate);
	
	@Modifying
	@Transactional
	@Query("update InformationBoard c set c.title= :title, c.conts = :conts, c.image = :image, c.wdate = :wdate where c.infoBoardSeq = :infoBoardSeq")
	void updateInfo(@Param("infoBoardSeq") Long infoBoardSeq, @Param("title") String title, @Param("conts") String conts, @Param("image") String image, @Param("wdate") String wdate);
	
//	@Query("update InformationBoard set wdate where i.infoBoardSeq = :infoBoardSeq")
//	InformationBoard deletInfo(@Param("infoBoardSeq") int infoBoardSeq);
//	
//	@("update from infoBoard i set i.title = :title, i.conts, i.")

}
