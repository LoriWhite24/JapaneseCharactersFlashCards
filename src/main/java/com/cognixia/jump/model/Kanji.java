package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "kanjis")
public class Kanji implements Serializable{
	
	public enum JLPTLevel {
		JLPT_N1, JLPT_N2, JLPT_N3, JLPT_N4, JLPT_N5; 
	}
	
	public enum Grade {
		Grade_1, Grade_2, Grade_3, Grade_4, Grade_5, Grade_6, Grade_S, USED_IN_NAMES;
	}
	
	private static final long serialVersionUID = -349817696637165461L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name = "character_value", unique = true)
	private String character;
	@Enumerated(EnumType.STRING)
	private JLPTLevel jlptLevel;
	@Enumerated(EnumType.STRING)
	private Grade grade;
	@NotNull
	private String strokeOrder;
	@NotNull
	private Integer numOfStrokes;
	private Integer frequency;
	@NotBlank
	private String meaning;
	@NotBlank
	private String kunyomi;
	@NotBlank
	private String onyomi;
	@JsonIgnore
	@ManyToMany(mappedBy = "kanjis", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyList> studyLists = new HashSet<StudyList>();
	
	public Kanji() {
		this("該当なし", JLPTLevel.JLPT_N1, Grade.Grade_1, "N/A", -1, -1, "N/A", "N/A", "N/A");
	}

	public Kanji(String character, JLPTLevel jlptLevel, Grade grade, String strokes, Integer numOfStrokes, Integer frequency, String meaning, String kunyomi, String onyomi) {
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

	public JLPTLevel getJlptLevel() {
		return jlptLevel;
	}

	public void setJlptLevel(JLPTLevel jlptLevel) {
		this.jlptLevel = jlptLevel;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
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
}
