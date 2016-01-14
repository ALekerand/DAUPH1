package com.lekerand.model;
// Generated 14 janv. 2016 15:58:37 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Enseigner generated by hbm2java
 */
@Entity
@Table(name = "enseigner", catalog = "dauphin_bd")
public class Enseigner implements java.io.Serializable {

	private EnseignerId id;
	private Classe classe;
	private Personnel personnel;
	private String anneeScolaire;

	public Enseigner() {
	}

	public Enseigner(EnseignerId id, Classe classe, Personnel personnel) {
		this.id = id;
		this.classe = classe;
		this.personnel = personnel;
	}

	public Enseigner(EnseignerId id, Classe classe, Personnel personnel, String anneeScolaire) {
		this.id = id;
		this.classe = classe;
		this.personnel = personnel;
		this.anneeScolaire = anneeScolaire;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idClasse", column = @Column(name = "ID_CLASSE", nullable = false) ),
			@AttributeOverride(name = "idPersonnel", column = @Column(name = "ID_PERSONNEL", nullable = false) ) })
	public EnseignerId getId() {
		return this.id;
	}

	public void setId(EnseignerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLASSE", nullable = false, insertable = false, updatable = false)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONNEL", nullable = false, insertable = false, updatable = false)
	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	@Column(name = "ANNEE_SCOLAIRE", length = 10)
	public String getAnneeScolaire() {
		return this.anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

}
