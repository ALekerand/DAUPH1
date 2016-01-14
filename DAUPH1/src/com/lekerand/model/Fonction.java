package com.lekerand.model;
// Generated 14 janv. 2016 15:58:37 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Fonction generated by hbm2java
 */
@Entity
@Table(name = "fonction", catalog = "dauphin_bd")
public class Fonction implements java.io.Serializable {

	private int codeFonction;
	private String libelleFonction;
	private Set<Personnel> personnels = new HashSet<Personnel>(0);

	public Fonction() {
	}

	public Fonction(int codeFonction) {
		this.codeFonction = codeFonction;
	}

	public Fonction(int codeFonction, String libelleFonction, Set<Personnel> personnels) {
		this.codeFonction = codeFonction;
		this.libelleFonction = libelleFonction;
		this.personnels = personnels;
	}

	@Id

	@Column(name = "CODE_FONCTION", unique = true, nullable = false)
	public int getCodeFonction() {
		return this.codeFonction;
	}

	public void setCodeFonction(int codeFonction) {
		this.codeFonction = codeFonction;
	}

	@Column(name = "LIBELLE_FONCTION", length = 15)
	public String getLibelleFonction() {
		return this.libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fonction")
	public Set<Personnel> getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}

}