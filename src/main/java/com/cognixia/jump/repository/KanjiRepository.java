package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Kanji;
import com.cognixia.jump.model.Kanji.Grade;
import com.cognixia.jump.model.Kanji.JLPTLevel;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long>{
	List<Kanji> findAll();
	Kanji findByCharacter(String character);
	List<Kanji> findByjlptLevelContaining(JLPTLevel jlptLevel);
	List<Kanji> findByGradeContaining(Grade grade);
	List<Kanji> findByNumOfStrokesContaining(Integer numOfStrokes);
	List<Kanji> findByFrequencyContaining(Integer frequency);
	List<Kanji> findByMeaningContaining(String meaning);
	List<Kanji> findByKunyomiContaining(String kunyomi);
	List<Kanji> findByOnyomiContaining(String onyomi);
}
