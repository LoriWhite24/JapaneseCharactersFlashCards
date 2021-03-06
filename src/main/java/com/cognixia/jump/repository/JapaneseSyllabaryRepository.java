package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.JapaneseSyllabary;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabaryType;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabogramType;

@Repository
public interface JapaneseSyllabaryRepository extends JpaRepository<JapaneseSyllabary, Long>{
	List<JapaneseSyllabary> findAll();
	JapaneseSyllabary findByCharacter(String character);
	List<JapaneseSyllabary> findByReading(String reading);
	@Query("select js from JapaneseSyllabary js where js.type = ?1")
	List<JapaneseSyllabary> findByType(SyllabaryType type);
	@Query("select js from JapaneseSyllabary js where js.syllabogram = ?1")
	List<JapaneseSyllabary> findBySyllabogram(SyllabogramType syllabogram);
}
