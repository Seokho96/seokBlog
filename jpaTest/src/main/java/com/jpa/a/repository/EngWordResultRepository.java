package com.jpa.a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.a.entity.EngWordResult;

@Repository
public interface EngWordResultRepository extends JpaRepository<EngWordResult, Long> {

}
