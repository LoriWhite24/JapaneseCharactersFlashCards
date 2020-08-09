package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Kanji;
import com.cognixia.jump.model.Kanji.Grade;
import com.cognixia.jump.model.Kanji.JLPTLevel;
import com.cognixia.jump.repository.KanjiRepository;

@RequestMapping("/api")
@RestController
public class KanjiController {
	@Autowired
	KanjiRepository service;
	
	@GetMapping("/kanjis")
	public List<Kanji> getAllKanji() {
		return service.findAll();
	}
	
	@GetMapping("/kanjis/jlpt_level/{level}")
	public List<Kanji> getKanjiByJLPTLevel(@PathVariable String level) {
		switch(level) {
		case "JLPT_N1": 
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N1);
		case "JLPT_N2":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N2);
		case "JLPT_N3":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N3);
		case "JLPT_N4":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N4);
		case "JLPT_N5":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N5);
		default:
			return new ArrayList<Kanji>();
		}
	}
	
	@GetMapping("/kanjis/grade/{grade}")
	public List<Kanji> getKanjiByGrade(@PathVariable String grade) {
		switch(grade) {
		case "Grade_1": 
			return service.findByGradeContaining(Grade.Grade_1);
		case "Grade_2":
			return service.findByGradeContaining(Grade.Grade_2);
		case "Grade_3":
			return service.findByGradeContaining(Grade.Grade_3);
		case "Grade_4":
			return service.findByGradeContaining(Grade.Grade_4);
		case "Grade_5":
			return service.findByGradeContaining(Grade.Grade_5);
		case "Grade_6":
			return service.findByGradeContaining(Grade.Grade_6);
		case "Grade_S":
			return service.findByGradeContaining(Grade.Grade_S);
		case "Used_In_Names":
			return service.findByGradeContaining(Grade.USED_IN_NAMES);
		default:
			return new ArrayList<Kanji>();
		}
		
	}
	
	@GetMapping("/kanjis/number_of_strokes/{strokes}")
	public List<Kanji> getKanjiByNumberOfStrokes(@PathVariable String strokes) {
		return service.findByNumOfStrokesContaining(Integer.parseInt(strokes));
	}
	
	@GetMapping("/kanjis/frequency/{frequency}")
	public List<Kanji> getKanjiByFrequency(@PathVariable String frequency) {
		return service.findByFrequencyContaining(Integer.parseInt(frequency));
	}
	
	@GetMapping("/kanjis/meaning/{meaning}")
	public List<Kanji> getKanjiByMeaning(@PathVariable String meaning) {
		return service.findByMeaningContaining(meaning);
	}
	
	@GetMapping("/kanjis/kunyomi/{kunyomi}")
	public List<Kanji> getKanjiByKunyomi(@PathVariable String kunyomi) {
		return service.findByKunyomiContaining(kunyomi);
	}
	
	@GetMapping("/kanjis/onyomi/{onyomi}")
	public List<Kanji> getKanjiByOnyomi(@PathVariable String onyomi) {
		return service.findByOnyomiContaining(onyomi);
	}
	
	@GetMapping("/kanjis/character/{character}")
	public Kanji getKanjiByCharacter(@PathVariable String character) {
		return service.findByCharacter(character);
	}
}
