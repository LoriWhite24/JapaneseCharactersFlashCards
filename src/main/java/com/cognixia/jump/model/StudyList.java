package com.cognixia.jump.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

@Entity 
@Table(name = "studylists")
public class StudyList implements Serializable{
	@Autowired
	private static final long serialVersionUID = 2383519086789330186L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "studylists_syllabaries", joinColumns = {@JoinColumn(name = "syllabary_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "studylist_id", referencedColumnName = "id", nullable = false, updatable = false)})
	private Set<JapaneseSyllabary> syllabaries = new HashSet<JapaneseSyllabary>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "studylists_kanjis", joinColumns = {@JoinColumn(name = "kanji_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "studylist_id", referencedColumnName = "id", nullable = false, updatable = false)})
	private Set<Kanji> kanjis = new HashSet<Kanji>();
	
	public StudyList() {
		this("N/A");
	}
	
	public StudyList(String name) {
		super();
		this.name = name;
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

	public Set<JapaneseSyllabary> getSyllabaries() {
		return syllabaries;
	}

	public void setSyllabaries(Set<JapaneseSyllabary> syllabaries) {
		this.syllabaries = syllabaries;
	}

	public Set<Kanji> getKanjis() {
		return kanjis;
	}

	public void setKanjis(Set<Kanji> kanjis) {
		this.kanjis = kanjis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public String toString() {
		return "StudyList [id=" + id + ", name=" + name + ", syllabaries=" + syllabaries + ", kanjis=" + kanjis + "]";
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
