package com.lekerand.model;
// Generated 18 janv. 2016 18:33:35 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Frais generated by hbm2java
 */
@Entity
@Table(name = "frais", catalog = "dauphin_bd")
public class Frais implements java.io.Serializable {

	private int codeFrais;
	private Float fraisGeneraux;
	private Float fraisScolarite;
	private Set<FraisClasse> fraisClasses = new HashSet<FraisClasse>(0);

	public Frais() {
	}

	public Frais(int codeFrais) {
		this.codeFrais = codeFrais;
	}

	public Frais(int codeFrais, Float fraisGeneraux, Float fraisScolarite, Set<FraisClasse> fraisClasses) {
		this.codeFrais = codeFrais;
		this.fraisGeneraux = fraisGeneraux;
		this.fraisScolarite = fraisScolarite;
		this.fraisClasses = fraisClasses;
	}

	@Id

	@Column(name = "CODE_FRAIS", unique = true, nullable = false)
	public int getCodeFrais() {
		return this.codeFrais;
	}

	public void setCodeFrais(int codeFrais) {
		this.codeFrais = codeFrais;
	}

	@Column(name = "FRAIS_GENERAUX", precision = 10, scale = 0)
	public Float getFraisGeneraux() {
		return this.fraisGeneraux;
	}

	public void setFraisGeneraux(Float fraisGeneraux) {
		this.fraisGeneraux = fraisGeneraux;
	}

	@Column(name = "FRAIS_SCOLARITE", precision = 10, scale = 0)
	public Float getFraisScolarite() {
		return this.fraisScolarite;
	}

	public void setFraisScolarite(Float fraisScolarite) {
		this.fraisScolarite = fraisScolarite;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "frais")
	public Set<FraisClasse> getFraisClasses() {
		return this.fraisClasses;
	}

	public void setFraisClasses(Set<FraisClasse> fraisClasses) {
		this.fraisClasses = fraisClasses;
	}

}
