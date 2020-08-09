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
	public List<JapaneseSyllabary> getJapaneseSyllabariesByType(@PathVariable String type) {
		switch(type) {
		case "hiragana": 
			return service.findByType(SyllabaryType.HIRAGANA);
		case "katakana":
			return service.findByType(SyllabaryType.KATAKANA);
		default:
			return new ArrayList<JapaneseSyllabary>();
		}
		
	}
	
	@GetMapping("/japanese_syllabaries/syllabogram/{syllabogram}")
	public List<JapaneseSyllabary> getJapaneseSyllabariesBySyllabogram(@PathVariable String syllabogram) {
		switch(syllabogram) {
		case "monographs": 
			return service.findBySyllabogram(SyllabogramType.MONOGRAPHS);
		case "diagraphs":
			return service.findBySyllabogram(SyllabogramType.DIAGRAPHS);
		case "diacritics":
			return service.findBySyllabogram(SyllabogramType.DIACRITICS);
		case "diagraphs_with_diacritics":
			return service.findBySyllabogram(SyllabogramType.DIAGRAPHS_WITH_DIACRITICS);
		default:
			return new ArrayList<JapaneseSyllabary>();
		}
		
	}
	
	@GetMapping("/japanese_syllabaries/reading/{read}")
	public List<JapaneseSyllabary> getJapaneseSyllabariesByReading(@PathVariable String read) {
		return service.findByReading(read);
	}
	
	@GetMapping("/japanese_syllabaries/character/{character}")
	public JapaneseSyllabary getJapaneseSyllabaryByCharacter(@PathVariable String character) {
		return service.findByCharacter(character);
	}
}
