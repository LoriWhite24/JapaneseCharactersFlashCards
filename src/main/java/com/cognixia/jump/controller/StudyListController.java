package com.cognixia.jump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
