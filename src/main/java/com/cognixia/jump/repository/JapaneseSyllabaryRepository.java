package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.JapaneseSyllabary;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabaryType;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabogramType;

@Repository
public interface JapaneseSyllabaryRepository extends JpaRepository<JapaneseSyllabary, Long>{
	List<JapaneseSyllabary> findAll();
	JapaneseSyllabary findByCharacterContaining(String character);
	List<JapaneseSyllabary> findByReadingContaining(String reading);
	List<JapaneseSyllabary> findByTypeContaining(SyllabaryType type);
	List<JapaneseSyllabary> findBySyllabogramContaining(SyllabogramType syllabogram);
}
