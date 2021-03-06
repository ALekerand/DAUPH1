package com.lekerand.model;
// Generated 18 janv. 2016 18:33:35 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe generated by hbm2java
 */
@Entity
@Table(name = "classe", catalog = "dauphin_bd")
public class Classe implements java.io.Serializable {

	private int idClasse;
	private CycleScolaire cycleScolaire;
	private Niveau niveau;
	private String libClasse;
	private String abrevClasse;
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	private Set<Enseigner> enseigners = new HashSet<Enseigner>(0);
	private Set<FraisClasse> fraisClasses = new HashSet<FraisClasse>(0);

	public Classe() {
	}

	public Classe(int idClasse, CycleScolaire cycleScolaire, Niveau niveau) {
		this.idClasse = idClasse;
		this.cycleScolaire = cycleScolaire;
		this.niveau = niveau;
	}

	public Classe(int idClasse, CycleScolaire cycleScolaire, Niveau niveau, String libClasse, String abrevClasse,
			Set<Inscription> inscriptions, Set<Enseigner> enseigners, Set<FraisClasse> fraisClasses) {
		this.idClasse = idClasse;
		this.cycleScolaire = cycleScolaire;
		this.niveau = niveau;
		this.libClasse = libClasse;
		this.abrevClasse = abrevClasse;
		this.inscriptions = inscriptions;
		this.enseigners = enseigners;
		this.fraisClasses = fraisClasses;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "ID_CLASSE", unique = true, nullable = false)
	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SYCLESCOLAIRE", nullable = false)
	public CycleScolaire getCycleScolaire() {
		return this.cycleScolaire;
	}

	public void setCycleScolaire(CycleScolaire cycleScolaire) {
		this.cycleScolaire = cycleScolaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NIVEAU", nullable = false)
	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@Column(name = "LIB_CLASSE", length = 25)
	public String getLibClasse() {
		return this.libClasse;
	}

	public void setLibClasse(String libClasse) {
		this.libClasse = libClasse;
	}

	@Column(name = "ABREV_CLASSE", length = 5)
	public String getAbrevClasse() {
		return this.abrevClasse;
	}

	public void setAbrevClasse(String abrevClasse) {
		this.abrevClasse = abrevClasse;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public Set<Enseigner> getEnseigners() {
		return this.enseigners;
	}

	public void setEnseigners(Set<Enseigner> enseigners) {
		this.enseigners = enseigners;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public Set<FraisClasse> getFraisClasses() {
		return this.fraisClasses;
	}

	public void setFraisClasses(Set<FraisClasse> fraisClasses) {
		this.fraisClasses = fraisClasses;
	}

}
