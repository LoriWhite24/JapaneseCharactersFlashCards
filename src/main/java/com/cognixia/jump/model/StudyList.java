package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity 
public class StudyList implements Serializable{

	private static final long serialVersionUID = 2383519086789330186L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studyList_id", unique = true, nullable = false)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String name;
//	@OneToMany(mappedBy = "syllabary", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<JapaneseSyllabary> syllabaries = new HashSet<JapaneseSyllabary>();
//	@OneToMany(mappedBy = "kanji", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Kanji> kanjis = new HashSet<Kanji>();
	
	public StudyList() {
		this("N/A", new HashSet<JapaneseSyllabary>(), new HashSet<Kanji>());
	}
	
	public StudyList(String name, Set<JapaneseSyllabary> syllabaries, Set<Kanji> kanjis) {
		super();
		this.name = name;
//		this.syllabaries = syllabaries;
//		this.kanjis = kanjis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<JapaneseSyllabary> getSyllabaries() {
//		return syllabaries;
//	}
//
//	public void setSyllabaries(Set<JapaneseSyllabary> syllabaries) {
//		this.syllabaries = syllabaries;
//	}
//
//	public Set<Kanji> getKanjis() {
//		return kanjis;
//	}
//
//	public void setKanjis(Set<Kanji> kanjis) {
//		this.kanjis = kanjis;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public String toString() {
		return "StudyList [id=" + id + ", name=" + name + /*", syllabaries=" + syllabaries + ", kanjis=" + kanjis + */"]";
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        StudyList toCompare = (StudyList) obj;
        return id.equals(toCompare.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
