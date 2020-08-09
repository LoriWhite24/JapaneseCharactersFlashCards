package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.JapaneseSyllabary;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabaryType;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabogramType;
import com.cognixia.jump.repository.JapaneseSyllabaryRepository;

@RequestMapping("/api")
@RestController
public class JapaneseSyllabaryController {
	@Autowired
	JapaneseSyllabaryRepository service;
	
	@GetMapping("/japanese_syllabaries")
	public List<JapaneseSyllabary> getAllJapaneseSyllabaries() {
		return service.findAll();
	}
	
	@GetMapping("/japanese_syllabaries/type/{type}")
	public List<JapaneseSyllabary> getType(@PathVariable String type) {
		switch(type) {
		case "hiragana": 
			return service.findByTypeContaining(SyllabaryType.HIRAGANA);
		case "katakana":
			return service.findByTypeContaining(SyllabaryType.KATAKANA);
		default:
			return new ArrayList<JapaneseSyllabary>();
		}
		
	}
	
	@GetMapping("/japanese_syllabaries/syllabogram/{syllabogram}")
	public List<JapaneseSyllabary> getSyllabogram(@PathVariable String syllabogram) {
		switch(syllabogram) {
		case "monographs": 
			return service.findBySyllabogramContaining(SyllabogramType.MONOGRAPHS);
		case "diagraphs":
			return service.findBySyllabogramContaining(SyllabogramType.DIAGRAPHS);
		case "diacritics":
			return service.findBySyllabogramContaining(SyllabogramType.DIACRITICS);
		case "diagraphs_with_diacritics":
			return service.findBySyllabogramContaining(SyllabogramType.DIAGRAPHS_WITH_DIACRITICS);
		default:
			return new ArrayList<JapaneseSyllabary>();
		}
		
	}
	
	@GetMapping("/japanese_syllabaries/reading/{read}")
	public List<JapaneseSyllabary> getSyllabariesByReading(@PathVariable String read) {
		return service.findByReadingContaining(read);
	}
	
	@GetMapping("/japanese_syllabaries/character/{character}")
	public JapaneseSyllabary getSyllabariesByType(@PathVariable String character) {
		return service.findByCharacterContaining(character);
	}
}
