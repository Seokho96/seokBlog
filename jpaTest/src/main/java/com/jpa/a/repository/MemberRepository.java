package com.jpa.a.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.member;

@Repository
public interface MemberRepository extends JpaRepository<member, Long>{

	

	
}
