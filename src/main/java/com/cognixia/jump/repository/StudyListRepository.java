package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.StudyList;

@Repository
public interface StudyListRepository extends JpaRepository<StudyList, Long>{
	List<StudyList> findByNameContaining(String name);
}
