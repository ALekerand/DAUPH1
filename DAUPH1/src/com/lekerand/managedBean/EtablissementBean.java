package com.lekerand.managedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lekerand.model.Etablissement;
import com.lekerand.service.Iservice;

@Component
public class EtablissementBean {
	@Autowired
	private Iservice service;
	@Autowired
	private FileUploadController fileUploadController;

	private Etablissement etablissement = new Etablissement();
	private String destination = "D:\\temp\\";
	private List listEtablis = new ArrayList<>();
	private Etablissement selectedEtab = new Etablissement();

	// Contrôle de coposant
	private CommandButton btnModifier = new CommandButton();
	private CommandButton btnValider = new CommandButton();
	private CommandButton btnSuprimer = new CommandButton();

	@PostConstruct
	public void ActivDesactiv() {
		btnModifier.setDisabled(true);
		btnSuprimer.setDisabled(true);
	}

	public void enregistrerEtablissement() {
		// Enregistrement possible
		getService().addObject(etablissement);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCCES!", "Enregistrement de l'établissement effcetué"));
		viderEtablisment(etablissement);
		btnValider.setDisabled(true);
	}

	public void annuler() {
		viderEtablisment(etablissement);
		//Recharger la liste
		listEtablis.clear();
		listEtablis = getService().getObjects("Etablissement");
		// Activation desactivation
		btnModifier.setDisabled(true);
		//btnValider.setDisabled(false);
		btnSuprimer.setDisabled(true);
	}

	public void supprimer() {
		getService().deleteObject(selectedEtab);
		//Recharger la liste
		listEtablis.clear();
		listEtablis = getService().getObjects("Etablissement");
		// Activation desactivation
		btnSuprimer.setDisabled(true);
		btnModifier.setDisabled(true);
		btnValider.setDisabled(false);
		viderEtablisment(etablissement);
	}

	public void viderEtablisment(Etablissement objEtablis) {
		objEtablis.setLogoEtablis(null);
		objEtablis.setNomEtablis(null);
		objEtablis.setSigneEtabl(null);
	}

	public void modifier() {
		Etablissement etablisModifie = getEtablissement();
		getService().updateObject(etablisModifie);
		//Recréer la liste
		listEtablis.clear();
		listEtablis = getService().getObjects("Etablissement");
		btnModifier.setDisabled(true);
		btnSuprimer.setDisabled(true);
		btnValider.setDisabled(false);
		viderEtablisment(etablissement);
	}

	public void selectionnerEtab() {
		// Charger la ligne du tableau
		setEtablissement(selectedEtab);
		// Activation et desactivation des bouttons
		btnValider.setDisabled(true);
		btnModifier.setDisabled(false);
		btnSuprimer.setDisabled(false);

	}
	
	public void majEtablissement(String nomFichier){
	if (listEtablis.size()!=0) {
		Etablissement objEtablis = (Etablissement) listEtablis.get(0);
		objEtablis.setLogoEtablis(destination+nomFichier);
		getService().updateObject(objEtablis);
	}
	}

	public void upload(FileUploadEvent event) {
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
			//Mis a jour en base de l'Etablissement
			majEtablissement(event.getFile().getFileName());
			FacesMessage msg = new FacesMessage("Success! Le logo a été uploadé", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {
		try {
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	/************* ACCESSEURS *************/
	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Iservice getService() {
		return service;
	}

	public void setService(Iservice service) {
		this.service = service;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public FileUploadController getFileUploadController() {
		return fileUploadController;
	}

	public void setFileUploadController(FileUploadController fileUploadController) {
		this.fileUploadController = fileUploadController;
	}

	public CommandButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(CommandButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public List getListEtablis() {
		if (listEtablis.size() == 0) {
			// charger la liste
			this.listEtablis = getService().getObjects("Etablissement");
		}else {
			//Desactiver le boutton de validation
			getBtnValider().setDisabled(true);
		}
		return listEtablis;
	}

	public void setListEtablis(List listEtablis) {
		this.listEtablis = listEtablis;
	}

	public Etablissement getSelectedEtab() {
		return selectedEtab;
	}

	public void setSelectedEtab(Etablissement selectedEtab) {
		this.selectedEtab = selectedEtab;
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
