package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.StudyList;
import com.cognixia.jump.repository.StudyListRepository;

@RequestMapping("/api")
@RestController
public class StudyListController {
	@Autowired
	StudyListRepository service;
	
	@GetMapping("/study")
	public String getMain() {
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h1>自習時間</h1>\r\n" + 
				"\r\n" + 
				"<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/3002_Kanji.svg/957px-3002_Kanji.svg.png\" alt=\"Study Hard!\">\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}
	
	@GetMapping("/studylists")
	public List<StudyList> getAllStudyLists() {
		return service.findAll();
	}
	
	@GetMapping("/studylists/name/{name}")
	public List<StudyList> getAllStudyListsByName(@PathVariable String name) {
		return service.findByNameContaining(name);
	}
	
//	@PutMapping("/update/studylist")
//	
//	@PatchMapping("/add/studylist/japanese_syllabary")
//	
//	@PatchMapping("/add/studylist/kanji")
//	
//	@PatchMapping("/delete/studylist/japanese_syllabary")
//	
//	@PatchMapping("/delete/studylist/kanji")
//	
//	@PostMapping("/add/studylist")
//	
//	@DeleteMapping("/delete/studylist/{id}")
}
