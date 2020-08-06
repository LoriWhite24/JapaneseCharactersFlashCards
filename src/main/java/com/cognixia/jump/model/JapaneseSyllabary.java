package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

enum SyllabaryType {
	HIRAGANA, KATAKANA;
}

enum SyllabogramType {
	MONOGRAPHS, DIAGRAPHS, DIACRITICS, DIAGRAPHS_WITH_DIACRITICS;
}

@Entity
@Table(name = "syllabaries")
public class JapaneseSyllabary implements Serializable{
	
	private static final long serialVersionUID = 3073455385620779001L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String character;
	@NotBlank
	private String reading;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private SyllabaryType type;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private SyllabogramType syllabogram;
	@NotNull
	private String strokeOrder; //the a link to a gif of the stroke order
	@NotBlank
	private int numOfStrokes;
	
	
	public JapaneseSyllabary() {
		this("該当なし", "N/A", SyllabaryType.HIRAGANA, SyllabogramType.MONOGRAPHS, "N/A", -1);
	}

	public JapaneseSyllabary(String character, String romanji, SyllabaryType type, SyllabogramType syllabogram, String strokeOrderImg, int strokes) {
		super();
		this.character = character;
		this.reading = romanji;
		this.type = type;
		this.syllabogram = syllabogram;
		this.strokeOrder = strokeOrderImg;
		this.numOfStrokes = strokes;
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

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public SyllabaryType getType() {
		return type;
	}

	public void setType(SyllabaryType type) {
		this.type = type;
	}

	public SyllabogramType getSyllabogram() {
		return syllabogram;
	}

	public void setSyllabogram(SyllabogramType syllabogram) {
		this.syllabogram = syllabogram;
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

	@Override
	public String toString() {
		return "JapaneseSyllabary [id=" + id + ", character=" + character + ", reading=" + reading + ", type=" + type
				+ ", syllabogram=" + syllabogram + ", strokeOrder=" + strokeOrder + ", numOfStrokes=" + numOfStrokes
				+ "]";
	}

}