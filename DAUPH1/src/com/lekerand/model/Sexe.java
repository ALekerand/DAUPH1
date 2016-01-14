package com.lekerand.model;
// Generated 14 janv. 2016 15:58:37 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Sexe generated by hbm2java
 */
@Entity
@Table(name = "sexe", catalog = "dauphin_bd")
public class Sexe implements java.io.Serializable {

	private int codeSexe;
	private String libSexe;
	private Set<Eleve> eleves = new HashSet<Eleve>(0);

	public Sexe() {
	}

	public Sexe(int codeSexe) {
		this.codeSexe = codeSexe;
	}

	public Sexe(int codeSexe, String libSexe, Set<Eleve> eleves) {
		this.codeSexe = codeSexe;
		this.libSexe = libSexe;
		this.eleves = eleves;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "CODE_SEXE", unique = true, nullable = false)
	public int getCodeSexe() {
		return this.codeSexe;
	}

	public void setCodeSexe(int codeSexe) {
		this.codeSexe = codeSexe;
	}

	@Column(name = "LIB_SEXE", length = 2)
	public String getLibSexe() {
		return this.libSexe;
	}

	public void setLibSexe(String libSexe) {
		this.libSexe = libSexe;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sexe")
	public Set<Eleve> getEleves() {
		return this.eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}

}
