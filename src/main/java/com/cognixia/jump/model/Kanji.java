package com.cognixia.jump.model;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "kanji")
public class Kanji implements Serializable{

	private static final long serialVersionUID = -349817696637165461L;
//	private static final List<JapaneseSyllabary> SYLLABARIES = new ArrayList<JapaneseSyllabary>();
//	
//	static {
//		BufferedReader br;
//		String[] files = {"hiragana", "katakana"};
//		for(int i = 0; i < files.length; i++) {
//			try {
//				br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/" + files[i] + ".csv"), "UTF-8"));
//				String line;
//				String[] tokens;
//				while((line = br.readLine()) != null) {
//					 tokens = line.trim().split(",");
//					 SYLLABARIES.add(new JapaneseSyllabary(tokens[0], tokens[1], files[i], tokens[2], tokens[3], Integer.parseInt(tokens[4])));
//				}
//				br.close();
//			} catch(IOException e) {
//				System.out.println("Failed to read in " + files[i] + ".");
//			}
//		}
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String character;
	private String jlptLevel;
	private String grade;
	@NotNull
	private String strokeOrder;
	@NotBlank
	private int numOfStrokes;
	private int frequency;
	@NotEmpty
	private List<String> meaning = new ArrayList<String>();
	@NotEmpty
	private List<String> kunyomi = new ArrayList<String>();
	@NotEmpty
	private List<String> onyomi = new ArrayList<String>();
	@ManyToMany(mappedBy = "kanji", fetch = FetchType.LAZY)
    private Set<StudyList> studyLists = new HashSet<StudyList>();
	
	public Kanji() {
		this("該当なし", "N/A", "N/A", "N/A", -1, -1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
	}

	public Kanji(String character, String jlptLevel, String grade, String strokes, int numOfStrokes, int frequency, List<String> meaning, List<String> kunyomi, List<String> onyomi) {
		super();
		this.character = character;
		this.jlptLevel = jlptLevel;
		this.grade = grade;
		this.strokeOrder = strokes;
		this.numOfStrokes = numOfStrokes;
		this.frequency = frequency;
		this.meaning = meaning;
		this.kunyomi = kunyomi;
		this.onyomi = onyomi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getJlptLevel() {
		return jlptLevel;
	}

	public void setJlptLevel(String jlptLevel) {
		this.jlptLevel = jlptLevel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStrokeOrder() {
		return strokeOrder;
	}

	public void setStrokeOrder(String strokeOrder) {
		this.strokeOrder = strokeOrder;
	}

	public int getNumOfStrokes() {
		return numOfStrokes;
	}

	public void setNumOfStrokes(int numOfStrokes) {
		this.numOfStrokes = numOfStrokes;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public List<String> getMeaning() {
		return meaning;
	}

	public void setMeaning(List<String> meaning) {
		this.meaning = meaning;
	}

	public List<String> getKunyomi() {
		return kunyomi;
	}

	public void setKunyomi(List<String> kunyomi) {
		this.kunyomi = kunyomi;
	}

	public List<String> getOnyomi() {
		return onyomi;
	}

	public void setOnyomi(List<String> onyomi) {
		this.onyomi = onyomi;
	}

	public Set<StudyList> getStudyLists() {
		return studyLists;
	}

	public void setStudyLists(Set<StudyList> studyLists) {
		this.studyLists = studyLists;
	}

	@Override
	public String toString() {
		return "Kanji [id=" + id + ", character=" + character + ", jlptLevel=" + jlptLevel + ", grade=" + grade
				+ ", strokeOrder=" + strokeOrder + ", numOfStrokes=" + numOfStrokes + ", frequency=" + frequency
				+ ", meaning=" + meaning + ", kunyomi=" + kunyomi + ", onyomi=" + onyomi + "]";
	}

//	public static List<JapaneseSyllabary> getSyllabaries() {
//		return SYLLABARIES;
//	}

}
