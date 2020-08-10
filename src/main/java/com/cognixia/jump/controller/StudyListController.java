package com.cognixia.jump.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.StudyList;
import com.cognixia.jump.repository.StudyListRepository;

@RequestMapping("/api")
@RestController
public class StudyListController {
	@Autowired
	StudyListRepository service;
	
	@GetMapping("/studylists")
	public List<StudyList> getAllStudyLists() {
		return service.findAll();
	}
	
	@GetMapping("/studylists/name/{name}")
	public List<StudyList> getAllStudyListsByName(@PathVariable String name) {
		return service.findByNameContaining(name);
	}
	
	@PutMapping("/update/studylist")
	public void updateAccount(@Valid @RequestBody StudyList list) {
		if(service.existsById(list.getId())) {
			service.save(list);
		}
	}
//	@PatchMapping("/add/studylist/japanese_syllabary")
//	
//	@PatchMapping("/add/studylist/kanji")
//	
//	@PatchMapping("/delete/studylist/japanese_syllabary")
//	
//	@PatchMapping("/delete/studylist/kanji")
//	
	@PostMapping("/add/studylist")
	public ResponseEntity<String> addStudyList(@Valid @RequestBody StudyList list) {
		if(service.existsById(list.getId())) {
			return ResponseEntity.status(400).body("Account with id = " + list.getId() + " already exists.");
		} else {
			StudyList created = service.save(list);
			return ResponseEntity.status(201).body("Created: " + created);
		}
	}
	@DeleteMapping("/delete/studylist/{id}")
	public void deleteStudyList(@PathVariable long id) {
		service.deleteById(id);
	}
}
