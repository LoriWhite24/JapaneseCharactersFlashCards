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
		case "JLPT N1": 
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N1);
		case "JLPT N2":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N2);
		case "JLPT N3":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N3);
		case "JLPT N4":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N4);
		case "JLPT N5":
			return service.findByjlptLevelContaining(JLPTLevel.JLPT_N5);
		default:
			return new ArrayList<Kanji>();
		}
		
	}
	
	@GetMapping("/kanjis/grade/{grade}")
	public List<Kanji> getKanjiByGrade(@PathVariable String grade) {
		switch(grade) {
		case "Grade 1": 
			return service.findByGradeContaining(Grade.Grade_1);
		case "Grade 2":
			return service.findByGradeContaining(Grade.Grade_2);
		case "Grade 3":
			return service.findByGradeContaining(Grade.Grade_3);
		case "Grade 4":
			return service.findByGradeContaining(Grade.Grade_4);
		case "Grade 5":
			return service.findByGradeContaining(Grade.Grade_5);
		case "Grade 6":
			return service.findByGradeContaining(Grade.Grade_6);
		case "Grade S":
			return service.findByGradeContaining(Grade.Grade_S);
		case "Used in Names":
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
	public List<Kanji> getSyllabariesByMeaning(@PathVariable String meaning) {
		return service.findByMeaningContaining(meaning);
	}
	
	@GetMapping("/kanjis/character/{character}")
	public Kanji getSyllabariesByType(@PathVariable String character) {
		return service.findByCharacter(character);
	}
}
