package com.lekerand.model;
// Generated 18 janv. 2016 18:33:35 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EnseignerId generated by hbm2java
 */
@Embeddable
public class EnseignerId implements java.io.Serializable {

	private int idClasse;
	private int idPersonnel;

	public EnseignerId() {
	}

	public EnseignerId(int idClasse, int idPersonnel) {
		this.idClasse = idClasse;
		this.idPersonnel = idPersonnel;
	}

	@Column(name = "ID_CLASSE", nullable = false)
	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	@Column(name = "ID_PERSONNEL", nullable = false)
	public int getIdPersonnel() {
		return this.idPersonnel;
	}

	public void setIdPersonnel(int idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EnseignerId))
			return false;
		EnseignerId castOther = (EnseignerId) other;

		return (this.getIdClasse() == castOther.getIdClasse()) && (this.getIdPersonnel() == castOther.getIdPersonnel());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdClasse();
		result = 37 * result + this.getIdPersonnel();
		return result;
	}

}
