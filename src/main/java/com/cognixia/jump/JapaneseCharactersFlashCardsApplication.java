package com.cognixia.jump;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.cognixia.jump.model.JapaneseSyllabary;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabaryType;
import com.cognixia.jump.model.JapaneseSyllabary.SyllabogramType;
import com.cognixia.jump.model.Kanji;
import com.cognixia.jump.model.Kanji.Grade;
import com.cognixia.jump.model.Kanji.JLPTLevel;
import com.cognixia.jump.repository.JapaneseSyllabaryRepository;
import com.cognixia.jump.repository.KanjiRepository;

@SpringBootApplication
public class JapaneseCharactersFlashCardsApplication {
	@Autowired
	private JapaneseSyllabaryRepository japaneseSyllabaryRepository;
	@Autowired
	private KanjiRepository kanjiRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JapaneseCharactersFlashCardsApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			BufferedReader br;
			String[] files = {"hiragana", "katakana", "kanji"};
			SyllabaryType type = null;
			SyllabogramType gram = null;
			JLPTLevel level = null;
			Grade grade = null;
			for(int i = 0; i < files.length; i++) {
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/" + files[i] + ".csv"), "UTF-8"));
					String line;
					String[] tokens;
					while((line = br.readLine()) != null) {
						 tokens = line.trim().split(",");
						 if(files[i].equals("kanji")) {
							 switch(tokens[1]) {
								case "JLPT N1": 
									level = JLPTLevel.JLPT_N1;
									break;
								case "JLPT N2":
									level = JLPTLevel.JLPT_N2;
									break;
								case "JLPT N3":
									level = JLPTLevel.JLPT_N3;
									break;
								case "JLPT N4":
									level = JLPTLevel.JLPT_N4;
									break;
								case "JLPT N5":
									level = JLPTLevel.JLPT_N5;
									break;
							 }
							 switch(tokens[2]) {
								case "Grade 1": 
									grade = Grade.Grade_1;
									break;
								case "Grade 2":
									grade = Grade.Grade_2;
									break;
								case "Grade 3":
									grade = Grade.Grade_3;
									break;
								case "Grade 4":
									grade = Grade.Grade_4;
									break;
								case "Grade 5":
									grade = Grade.Grade_5;
									break;
								case "Grade 6":
									grade = Grade.Grade_6;
									break;
								case "Grade S":
									grade = Grade.Grade_S;
									break;
								case "Used in Names":
									grade = Grade.USED_IN_NAMES;
									break;
							 }
							 kanjiRepository.save(new Kanji(tokens[0], level, grade, tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6].replaceAll(":", ","), tokens[7].replaceAll(":", ","), tokens[8].replaceAll(":", ",")));
						 } else {
							 switch(files[i]) {
								case "hiragana": 
									type = SyllabaryType.HIRAGANA;
									break;
								case "katakana":
									type = SyllabaryType.KATAKANA;
									break;
							 }
							 switch(tokens[2]) {
								case "monographs": 
									gram = SyllabogramType.MONOGRAPHS;
									break;
								case "diagraphs":
									gram = SyllabogramType.DIAGRAPHS;
									break;
								case "diacritics":
									gram = SyllabogramType.DIACRITICS;
									break;
								case "diagraphs with diacritics":
									gram = SyllabogramType.DIAGRAPHS_WITH_DIACRITICS;
									break;
							 }
							 japaneseSyllabaryRepository.save(new JapaneseSyllabary(tokens[0], tokens[1], type, gram, tokens[3], Integer.parseInt(tokens[4])));
						 }
					}
					br.close();
				} catch(IOException e) {
					System.out.println("Failed to read in " + files[i] + ".");
				}
			}
		};
	}
}
