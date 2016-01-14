package com.lekerand.model;
// Generated 14 janv. 2016 15:58:37 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Inscription generated by hbm2java
 */
@Entity
@Table(name = "inscription", catalog = "dauphin_bd")
public class Inscription implements java.io.Serializable {

	private String idInscription;
	private AnneeScolaire anneeScolaire;
	private Classe classe;
	private Eleve eleve;
	private Long montantScolarite;
	private Long montantVersee;
	private Long reste;
	private Date dateInscription;
	private Boolean etatScolarite;

	public Inscription() {
	}

	public Inscription(String idInscription, AnneeScolaire anneeScolaire, Classe classe, Eleve eleve) {
		this.idInscription = idInscription;
		this.anneeScolaire = anneeScolaire;
		this.classe = classe;
		this.eleve = eleve;
	}

	public Inscription(String idInscription, AnneeScolaire anneeScolaire, Classe classe, Eleve eleve,
			Long montantScolarite, Long montantVersee, Long reste, Date dateInscription, Boolean etatScolarite) {
		this.idInscription = idInscription;
		this.anneeScolaire = anneeScolaire;
		this.classe = classe;
		this.eleve = eleve;
		this.montantScolarite = montantScolarite;
		this.montantVersee = montantVersee;
		this.reste = reste;
		this.dateInscription = dateInscription;
		this.etatScolarite = etatScolarite;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "ID_INSCRIPTION", unique = true, nullable = false, length = 15)
	public String getIdInscription() {
		return this.idInscription;
	}

	public void setIdInscription(String idInscription) {
		this.idInscription = idInscription;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ANNEE_SCOLAIRE", nullable = false)
	public AnneeScolaire getAnneeScolaire() {
		return this.anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLASSE", nullable = false)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ELEVE", nullable = false)
	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	@Column(name = "MONTANT_SCOLARITE", precision = 10, scale = 0)
	public Long getMontantScolarite() {
		return this.montantScolarite;
	}

	public void setMontantScolarite(Long montantScolarite) {
		this.montantScolarite = montantScolarite;
	}

	@Column(name = "MONTANT_VERSEE", precision = 10, scale = 0)
	public Long getMontantVersee() {
		return this.montantVersee;
	}

	public void setMontantVersee(Long montantVersee) {
		this.montantVersee = montantVersee;
	}

	@Column(name = "RESTE", precision = 10, scale = 0)
	public Long getReste() {
		return this.reste;
	}

	public void setReste(Long reste) {
		this.reste = reste;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "DATE_INSCRIPTION", length = 8)
	public Date getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	@Column(name = "ETAT_SCOLARITE")
	public Boolean getEtatScolarite() {
		return this.etatScolarite;
	}

	public void setEtatScolarite(Boolean etatScolarite) {
		this.etatScolarite = etatScolarite;
	}

}
