package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Kanji;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long>{
	List<Kanji> findAll();
	List<Kanji> findByCharacterContaining(String character);
	List<Kanji> findByjlptLevelContaining(String jlptLevel);
	List<Kanji> findByGradeContaining(String grade);
	List<Kanji> findByNumOfStrokesContaining(int numOfStrokes);
	List<Kanji> findByMeaningContaining(String meaning);
	List<Kanji> findByKunyomiContaining(String kunyomi);
	List<Kanji> findByOnyomiContaining(String onyomi);
}
