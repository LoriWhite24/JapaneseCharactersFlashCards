package com.cognixia.jump.model;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "kanjis")
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
	@Column(name = "character_value", unique = true)
	private String character;
	private String jlptLevel;
	private String grade;
	@NotNull
	private String strokeOrder;
	@NotBlank
	private Integer numOfStrokes;
	private Integer frequency;
	@NotEmpty
	private String meaning;
	@NotEmpty
	private String kunyomi;
	@NotEmpty
	private String onyomi;
	@ManyToMany(mappedBy = "kanjis", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyList> studyLists = new HashSet<StudyList>();
	
	public Kanji() {
		this("該当なし", "N/A", "N/A", "N/A", -1, -1, "N/A", "N/A", "N/A");
	}

	public Kanji(String character, String jlptLevel, String grade, String strokes, Integer numOfStrokes, Integer frequency, String meaning, String kunyomi, String onyomi) {
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

	public Integer getNumOfStrokes() {
		return numOfStrokes;
	}

	public void setNumOfStrokes(Integer numOfStrokes) {
		this.numOfStrokes = numOfStrokes;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getKunyomi() {
		return kunyomi;
	}

	public void setKunyomi(String kunyomi) {
		this.kunyomi = kunyomi;
	}

	public String getOnyomi() {
		return onyomi;
	}

	public void setOnyomi(String onyomi) {
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

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        Kanji toCompare = (Kanji) obj;
        return id.equals(toCompare.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
	
//	public static List<JapaneseSyllabary> getSyllabaries() {
//		return SYLLABARIES;
//	}

}
