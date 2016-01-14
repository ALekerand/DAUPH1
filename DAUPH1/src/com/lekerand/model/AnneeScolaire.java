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
 * AnneeScolaire generated by hbm2java
 */
@Entity
@Table(name = "annee_scolaire", catalog = "dauphin_bd")
public class AnneeScolaire implements java.io.Serializable {

	private int idAnneeScolaire;
	private Integer debutAn;
	private Integer finAn;
	private String libAnneescolaire;
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	private Set<Versement> versements = new HashSet<Versement>(0);

	public AnneeScolaire() {
	}

	public AnneeScolaire(int idAnneeScolaire) {
		this.idAnneeScolaire = idAnneeScolaire;
	}

	public AnneeScolaire(int idAnneeScolaire, Integer debutAn, Integer finAn, String libAnneescolaire,
			Set<Inscription> inscriptions, Set<Versement> versements) {
		this.idAnneeScolaire = idAnneeScolaire;
		this.debutAn = debutAn;
		this.finAn = finAn;
		this.libAnneescolaire = libAnneescolaire;
		this.inscriptions = inscriptions;
		this.versements = versements;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "ID_ANNEE_SCOLAIRE", unique = true, nullable = false)
	public int getIdAnneeScolaire() {
		return this.idAnneeScolaire;
	}

	public void setIdAnneeScolaire(int idAnneeScolaire) {
		this.idAnneeScolaire = idAnneeScolaire;
	}

	@Column(name = "DEBUT_AN")
	public Integer getDebutAn() {
		return this.debutAn;
	}

	public void setDebutAn(Integer debutAn) {
		this.debutAn = debutAn;
	}

	@Column(name = "FIN_AN")
	public Integer getFinAn() {
		return this.finAn;
	}

	public void setFinAn(Integer finAn) {
		this.finAn = finAn;
	}

	@Column(name = "LIB_ANNEESCOLAIRE", length = 10)
	public String getLibAnneescolaire() {
		return this.libAnneescolaire;
	}

	public void setLibAnneescolaire(String libAnneescolaire) {
		this.libAnneescolaire = libAnneescolaire;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "anneeScolaire")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "anneeScolaire")
	public Set<Versement> getVersements() {
		return this.versements;
	}

	public void setVersements(Set<Versement> versements) {
		this.versements = versements;
	}

}