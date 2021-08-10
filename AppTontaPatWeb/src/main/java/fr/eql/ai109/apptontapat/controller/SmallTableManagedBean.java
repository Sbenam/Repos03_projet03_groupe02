package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;

@ManagedBean(name = "mbSmallTable")
@SessionScoped
public class SmallTableManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> species = new ArrayList<String>();
	private String selectedSpecie ;

	@EJB
	SpecieIBusiness specieIBusiness;
	
	@PostConstruct
	public void init() {
		species = getAll();
	}
	
	public List<String> getAll() {
		return specieIBusiness.extraireToutLesLabelsSpecies();
	}
	
	
	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public String getSelectedSpecie() {
		return selectedSpecie;
	}

	public void setSelectedSpecie(String selectedSpecie) {
		this.selectedSpecie = selectedSpecie;
	}

	
}
