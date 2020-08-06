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
import com.cognixia.jump.repository.JapaneseSyllabaryRepository;

@SpringBootApplication
public class JapaneseCharactersFlashCardsApplication {
	@Autowired
	private JapaneseSyllabaryRepository japaneseSyllabaryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JapaneseCharactersFlashCardsApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			BufferedReader br;
			String[] files = {"hiragana", "katakana"};
			SyllabaryType type = null;
			SyllabogramType gram = null;
			for(int i = 0; i < files.length; i++) {
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/" + files[i] + ".csv"), "UTF-8"));
					String line;
					String[] tokens;
					while((line = br.readLine()) != null) {
						 tokens = line.trim().split(",");
						 switch(files[i]) {
							case "hiragana": 
								type = SyllabaryType.HIRAGANA;
							case "katakana":
								type = SyllabaryType.KATAKANA;
						 }
						 switch(tokens[2]) {
							case "monographs": 
								gram = SyllabogramType.MONOGRAPHS;
							case "diagraphs":
								gram = SyllabogramType.DIAGRAPHS;
							case "diacritics":
								gram = SyllabogramType.DIACRITICS;
							case "diagraphs with diacritics":
								gram = SyllabogramType.DIAGRAPHS_WITH_DIACRITICS;
						 }
						 japaneseSyllabaryRepository.save(new JapaneseSyllabary(tokens[0], tokens[1], type, gram, tokens[3], Integer.parseInt(tokens[4])));
					}
					br.close();
				} catch(IOException e) {
					System.out.println("Failed to read in " + files[i] + ".");
				}
			}
		};
	}
}
