package com.jpa.a.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.Board;
import com.jpa.a.entity.member;



@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
       
   
        
        @Query("select u from Board u where u.category = :category")
        List<Board> findMini(@Param("category") String category);
        
        @Query("select u from Board u where u.category = :category")
        List<Board> findAll(@Param("category") String category);
     

}
