package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.RaceIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.TakeoutIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;

@ManagedBean(name = "mbHerd")
@SessionScoped
public class HerdManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Herd herd = new Herd();
	private String test;
	private List<String> races = new ArrayList<String>();
	private String selectedRace;
	private List<String> species = new ArrayList<String>();
	private String selectedSpecie;
	private List<String> takeouts = new ArrayList<String>();
	private String selectedTakeout;
	private TakeOut takeoutvalue;
	private Herd SelectHerd = new Herd();

	@PostConstruct
	public void init() {
		races = getAllRaceLabels();
		species = getAllSpecieLabels();
		takeouts = getAllTakeoutLabels();
		

	}

	@EJB
	private HerdIbusiness herdIBusiness;
	@EJB
	private RaceIBusiness raceIBusiness;
	@EJB
	private SpecieIBusiness specieIBusiness;
	@EJB
	private ZipCodeIBusiness zipCodeIBusiness;
	@EJB
	private TakeoutIBusiness takeoutIBusiness;

	public String supprimer(List<TakeOut> takeoutsList) {

		takeoutvalue = takeoutsList.get(Integer.parseInt(selectedTakeout) - 1);
		System.out.println("valeur de takeoutvalue ----------------------------" + takeoutvalue);

		System.out.println("valeur de selectedTakeout ----------------------------" + selectedTakeout);
		herd.setWithdraw(new Date());
		herd.setTakeout(takeoutvalue);
		herdIBusiness.mettreAJourUnTroupeau(herd);
		return "simpleArch.xhtml";
	}

	public void getHerdById(int id) {
		System.out.println("test d'apelle de function get test et id: " + id);
		herd = herdIBusiness.extraireTroupeauParId(id);

	}

	public Herd getHerd() {
		return herd;
	}

	public void setHerd(Herd herd) {
		this.herd = herd;
	}

	public String getTest(int id) {
		System.out.println("test d'apelle de function get test et id: " + id);
		return test;
	}

	public List<String> getRaces() {
		return races;
	}

	public void setRaces(List<String> races) {
		this.races = races;
	}

	public String getSelectedRace() {
		return selectedRace;
	}

	public void setSelectedRace(String selectedRace) {
		this.selectedRace = selectedRace;
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

	public List<String> getTakeouts() {
		return takeouts;
	}

	public void setTakeouts(List<String> takeouts) {
		this.takeouts = takeouts;
	}

	public String getSelectedTakeout() {
		return selectedTakeout;
	}

	public void setSelectedTakeout(String selectedTakeout) {
		this.selectedTakeout = selectedTakeout;
	}

	public TakeOut getTakeoutvalue() {
		return takeoutvalue;
	}

	public void setTakeoutvalue(TakeOut takeoutvalue) {
		this.takeoutvalue = takeoutvalue;
	}

	public Herd getSelectHerd() {
		return SelectHerd;
	}

	public void setSelectHerd(Herd selectHerd) {
		SelectHerd = selectHerd;
	}

	public List<String> getAllRaceLabels() {
		return raceIBusiness.extraireTouteLesracesLabels();
	}

	public List<String> getAllSpecieLabels() {
		return specieIBusiness.extraireToutLesLabelsSpecies();
	}

	public List<String> getAllTakeoutLabels() {
		return takeoutIBusiness.extraireToutesLesTakeoutLabels();
	}

	public Herd getHerdByIdAccount(int id) {
		return herdIBusiness.extraireTroupeauParIdAccount(id);
	}

	public List<Herd> getAllHerd() {
		return herdIBusiness.extraireToutLesTroupeaux();
	}

	public List<Herd> getAllHerdByIdAccount(int id) {
		return herdIBusiness.extraireToutLesTroupeauxParIdAccount(id);
	}

	public String getCityWithZipCode(String zipCode) {
		return zipCodeIBusiness.extraireVilleAvecCodePostale(zipCode);
	}

}
