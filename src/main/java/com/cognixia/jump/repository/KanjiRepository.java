package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Kanji;
import com.cognixia.jump.model.Kanji.Grade;
import com.cognixia.jump.model.Kanji.JLPTLevel;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long>{
	List<Kanji> findAll();
	Kanji findByCharacter(String character);
	@Query("select k from Kanji k where k.jlptLevel = ?1")
	List<Kanji> findByjlptLevelContaining(JLPTLevel jlptLevel);
	@Query("select k from Kanji k where k.grade = ?1")
	List<Kanji> findByGradeContaining(Grade grade);
	@Query("select k from Kanji k where k.numOfStrokes = ?1")
	List<Kanji> findByNumOfStrokesContaining(Integer numOfStrokes);
	@Query("select k from Kanji k where k.frequency = ?1")
	List<Kanji> findByFrequencyContaining(Integer frequency);
	List<Kanji> findByMeaningContaining(String meaning);
	List<Kanji> findByKunyomiContaining(String kunyomi);
	List<Kanji> findByOnyomiContaining(String onyomi);
}
