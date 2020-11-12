package com.jpa.a.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.Board;



@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
       
        List<Board> findAll();
        
        	
     

}
