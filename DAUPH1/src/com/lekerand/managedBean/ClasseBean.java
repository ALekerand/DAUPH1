package com.lekerand.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lekerand.model.Classe;
import com.lekerand.model.CycleScolaire;
import com.lekerand.model.Niveau;
import com.lekerand.service.Iservice;

@Component
public class ClasseBean {
	@Autowired
	Iservice service;
	private Classe classe = new Classe();
	private Classe selectedClasse = new Classe();
	private Niveau selectedNiveau = new Niveau();
	private CycleScolaire selectedCycleScolaire = new CycleScolaire();
	private List<Classe> listClasse = new ArrayList<>();
	private List<Niveau> listLiveau = new ArrayList<>();
	private List<CycleScolaire> listCycleScolaire = new ArrayList<>();
	
	// Contrôle de coposant
		private CommandButton btnValider = new CommandButton();
		private CommandButton btnSuprimer = new CommandButton();
	
	public void enregistrer(){
		classe.setCycleScolaire(selectedCycleScolaire);
		classe.setNiveau(selectedNiveau);
		getService().addObject(classe);
		actualiserList();
		viderClasse(classe);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement effcetué!", null));
	}

	public void annuler() {
		btnValider.setDisabled(false);
		btnSuprimer.setDisabled(true);
		viderClasse(classe);
		actualiserList();
	}
	
	public void viderClasse(Classe objclasse) {
		objclasse.setLibClasse(null);
		objclasse.setAbrevClasse(null);
	}
	
	public void actualiserList(){
		listClasse.clear();
		listClasse = getService().getObjects("Classe");
		}
	
	public void selectionner(){
		setClasse(selectedClasse);
		btnSuprimer.setDisabled(false);
		btnValider.setDisabled(true);
	}
	
	public void supprimer() {
		Classe classeTemp = new Classe();
		classeTemp = selectedClasse;
		getService().deleteObject(classeTemp);
		viderClasse(classe);
		actualiserList();
		btnValider.setDisabled(false);
		btnSuprimer.setDisabled(true);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression effcetuée!", null));
	}
	

	/******************ACCESSEURS************************/
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Iservice getService() {
		return service;
	}

	public void setService(Iservice service) {
		this.service = service;
	}

	public List<Classe> getListClasse() {
		return listClasse;
	}

	public void setListClasse(List<Classe> listClasse) {
		this.listClasse = listClasse;
	}

	public Classe getSelectedClasse() {
		return selectedClasse;
	}

	public void setSelectedClasse(Classe selectedClasse) {
		this.selectedClasse = selectedClasse;
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

	@SuppressWarnings("unchecked")
	public List<Niveau> getListLiveau() {
		if (listLiveau.isEmpty()) {
			listLiveau = getService().getObjects("Niveau");
		}
		return listLiveau;
	}

	public void setListLiveau(List<Niveau> listLiveau) {
		this.listLiveau = listLiveau;
	}

	public Niveau getSelectedNiveau() {
		return selectedNiveau;
	}

	public void setSelectedNiveau(Niveau selectedNiveau) {
		this.selectedNiveau = selectedNiveau;
	}

	public CycleScolaire getSelectedCycleScolaire() {
		return selectedCycleScolaire;
	}

	public void setSelectedCycleScolaire(CycleScolaire selectedCycleScolaire) {
		this.selectedCycleScolaire = selectedCycleScolaire;
	}

	@SuppressWarnings("unchecked")
	public List<CycleScolaire> getListCycleScolaire() {
		if (listCycleScolaire.isEmpty()) {
			listCycleScolaire = getService().getObjects("CycleScolaire");
		}
		return listCycleScolaire;
	}

	public void setListCycleScolaire(List<CycleScolaire> listCycleScolaire) {
		this.listCycleScolaire = listCycleScolaire;
	}
}
