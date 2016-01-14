package com.lekerand.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lekerand.model.AnneeScolaire;
import com.lekerand.service.Iservice;

@Component
public class AnneeScolaireBean {
	@Autowired
	private Iservice service;

	private AnneeScolaire anneeScolaire = new AnneeScolaire();
	private List listAnneScol = new ArrayList<>();
	private AnneeScolaire selectedAnn = new AnneeScolaire();

	// Contrôle de coposant
	private CommandButton btnValider = new CommandButton();
	private CommandButton btnSuprimer = new CommandButton();

	@PostConstruct
	public void ActivDesactiv() {
		btnSuprimer.setDisabled(true);
	}
	
	@PostConstruct
	public void rafraichirTable() {
		listAnneScol = getService().getObjects("AnneeScolaire");
	}
	
	public void actualiserList(){
	//	listAnneScol.clear();
		listAnneScol = getService().getObjects("AnneeScolaire");
	}

	public void enregistrer() {
		getService().addObject(anneeScolaire);
		viderAnneScolaire(anneeScolaire);
		actualiserList();// For the DataTable
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement effcetué!", null));
	}

	public void supprimer() {
		AnneeScolaire an = new AnneeScolaire();
		an = selectedAnn;
		getService().deleteObject(an);
		viderAnneScolaire(anneeScolaire);
		actualiserList();
		btnValider.setDisabled(false);
		btnSuprimer.setDisabled(true);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression effcetuée!", null));
	}
	
	public void annuler() {
		btnValider.setDisabled(false);
		btnSuprimer.setDisabled(true);
		viderAnneScolaire(anneeScolaire);
		actualiserList();
	}
	
	public void selectionnerAnnéeScol() {
		setAnneeScolaire(selectedAnn);
		btnSuprimer.setDisabled(false);
		btnValider.setDisabled(true);
	}

	public void viderAnneScolaire(AnneeScolaire objanneeScol) {
		objanneeScol.setDebutAn(null);
		objanneeScol.setFinAn(null);
		objanneeScol.setLibAnneescolaire(null);
	}
	
	public void verifAnecolaire(){
		
		
	}

	/****** Accesseurs ***********************************/
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public Iservice getService() {
		return service;
	}

	public void setService(Iservice service) {
		this.service = service;
	}

	public List getListAnneScol() {
		return listAnneScol;
	}

	public void setListAnneScol(List listAnneScol) {
		this.listAnneScol = listAnneScol;
	}

	public AnneeScolaire getSelectedAnn() {
		return selectedAnn;
	}

	public void setSelectedAnn(AnneeScolaire selectedAnn) {
		this.selectedAnn = selectedAnn;
	}

	public CommandButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(CommandButton btnValider) {
		this.btnValider = btnValider;
	}

	public CommandButton getBtnSuprimer() {
		return btnSuprimer;
	}

	public void setBtnSuprimer(CommandButton btnSuprimer) {
		this.btnSuprimer = btnSuprimer;
	}

}
