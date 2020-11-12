package com.jpa.a.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.member;

@Repository
public interface MemberRepository extends JpaRepository<member, Long>{
	
	List<member> findByUserId(String userId);
	
	@Query("select u from member u where u.userId = :userId and u.password = :password")
    member findMember(@Param("userId") String userId, @Param("password") String password);

}
