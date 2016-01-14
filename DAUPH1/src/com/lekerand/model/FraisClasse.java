package com.lekerand.model;
// Generated 14 janv. 2016 15:58:37 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FraisClasse generated by hbm2java
 */
@Entity
@Table(name = "frais_classe", catalog = "dauphin_bd")
public class FraisClasse implements java.io.Serializable {

	private FraisClasseId id;
	private Classe classe;
	private Frais frais;
	private Date date;

	public FraisClasse() {
	}

	public FraisClasse(FraisClasseId id, Classe classe, Frais frais) {
		this.id = id;
		this.classe = classe;
		this.frais = frais;
	}

	public FraisClasse(FraisClasseId id, Classe classe, Frais frais, Date date) {
		this.id = id;
		this.classe = classe;
		this.frais = frais;
		this.date = date;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idClasse", column = @Column(name = "ID_CLASSE", nullable = false) ),
			@AttributeOverride(name = "codeFrais", column = @Column(name = "CODE_FRAIS", nullable = false) ) })
	public FraisClasseId getId() {
		return this.id;
	}

	public void setId(FraisClasseId id) {
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
	@JoinColumn(name = "CODE_FRAIS", nullable = false, insertable = false, updatable = false)
	public Frais getFrais() {
		return this.frais;
	}

	public void setFrais(Frais frais) {
		this.frais = frais;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}