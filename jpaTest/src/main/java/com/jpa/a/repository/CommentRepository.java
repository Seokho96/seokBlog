package com.jpa.a.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	List<Comment> findAll(Sort sort);
	
	@Query("select c from Comment c where c.userName = :userName")
	List<Comment> findByUserName(@Param("userName") String userName);
}
