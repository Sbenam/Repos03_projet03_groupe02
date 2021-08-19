package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.RaceIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.TakeoutIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;
import fr.eql.ai109.apptontapat.web.PageManageBean;

@ManagedBean(name = "mbHerd")
@SessionScoped
public class HerdManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Herd> allHerd = new ArrayList<Herd>();
	private Herd herd = new Herd();
	private String name;
	private String adresse;
	private String zipcode;
	private int selectedseize;
	private int selectedarea;
	private String selectedStarting;
	private String selectedEnding;
	private String test;
	private List<String> races = new ArrayList<String>();
	private String selectedRace;
	private int intSelectedRace;
	private List<String> species = new ArrayList<String>();
	private Race racevalue;
	private String selectedSpecie;
	private int intSelectedSpecie;
	private List<String> takeouts = new ArrayList<String>();
	private String selectedTakeout;
	private TakeOut takeoutvalue;
	private Herd selectHerd = new Herd();
	Date dstarting ;
	Date dending ;

	@PostConstruct
	public void init() {

		races = raceIBusiness.extraireTouteLesracesLabels();
		species = specieIBusiness.extraireToutLesLabelsSpecies();
		takeouts = takeoutIBusiness.extraireToutesLesTakeoutLabels();

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

	public void addHerd2(PageManageBean bean, Account account) {
		herd.setSeize(selectedseize);
		herd.setArea((float) selectedarea);
		herd.setPhoto("https://cdn.pixabay.com/photo/2019/01/03/11/53/lamb-3910805_960_720.jpg");
		herd.setAdding(new Date());
		herd.setAccount(account);
		herd.setRace(getAllRace().get(intSelectedRace));
		System.err.println("starting herd: "+selectedStarting);
		System.err.println("ending herd: "+selectedEnding);
		try {
			dstarting = new SimpleDateFormat("yyyy-MM-dd").parse(selectedStarting);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			dending = new SimpleDateFormat("yyyy-MM-dd").parse(selectedEnding);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		herd.setStarting(dstarting);
		herd.setEnding(dending);
		herdIBusiness.ajoutTroupeau(herd);
		bean.setPage("troupeau_detail");
		bean.setPage2("blank");
	}

	public void addHerd1(PageManageBean bean) {
		herd = new Herd();
		herd.setName(name);
		herd.setAdress(adresse);
		herd.setZipcode(zipCodeIBusiness.extraireZipCodeAvecCodePostale(adresse));
		bean.setPage2("addherd2");
	}

	public List<Race> getAllRace() {
		return raceIBusiness.extraireTouteLesraces();
	}

	public List<Specie> getAllSpecie() {
		return specieIBusiness.extraireToutLesSpecies();
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

	public List<Herd> getAllHerdById(int id) {
		allHerd = herdIBusiness.extraireToutLesTroupeauxParIdAccount(id);
		if (selectHerd.getAccount() == null) {
			selectHerd = allHerd.get(0);
		}
		return allHerd;
	}

	public void updateHerd(PageManageBean pageManageBean, Herd herd) {
		selectHerd = herd;
		pageManageBean.setPage("troupeau_detail");
		pageManageBean.setPage2("updateherd");
	}

	public void getHerdDetail(PageManageBean pageManageBean, Herd herd) {
		selectHerd = herd;
		pageManageBean.setPage("troupeau_detail");
	}

	public String getCityWithZipCode(String zipCode) {
		return zipCodeIBusiness.extraireVilleAvecCodePostale(zipCode);
	}

	public String maj(List<Race> racesList) {

		racevalue = racesList.get(Integer.parseInt(selectedRace) - 1);
		System.out.println("valeur de racevalue ----------------------------" + racevalue);
		System.out.println("valeur de selectedTakeout ----------------------------" + selectedTakeout);
		herd.setRace(racevalue);
		herd.setName(name);
		System.out.println("valeur de name ----------------------------" + name);
//	herd.setAdress();
//	herd.setZipcode();
//	herd.setSeize();
//	herd.setDescription();
//	herd.setStarting();
//	herd.setEnding();
		herdIBusiness.mettreAJourUnTroupeau(herd);
		return "simpleArch.xhtml";
	}

//methode pour supprimer
	public String supprimer(List<TakeOut> takeoutsList) {

		takeoutvalue = takeoutsList.get(Integer.parseInt(selectedTakeout) - 1);
		herd.setWithdraw(new Date());
		herd.setTakeout(takeoutvalue);
		herdIBusiness.mettreAJourUnTroupeau(herd);
		return "simpleArch.xhtml";
	}

	public void getHerdById(int id) {
		herd = herdIBusiness.extraireTroupeauParId(id);
	}

	public Herd getHerd() {
		return herd;
	}

	public void setHerd(Herd herd) {
		this.herd = herd;
	}

	public String getTest(int id) {
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
		return selectHerd;
	}

	public void setSelectHerd(Herd herd) {
		selectHerd = herd;
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

	public void setAllHerd(List<Herd> allHerd) {
		this.allHerd = allHerd;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getIntSelectedSpecie() {
		return intSelectedSpecie;
	}

	public void setIntSelectedSpecie(int intSelectedSpecie) {
		this.intSelectedSpecie = intSelectedSpecie;
	}

	public int getIntSelectedRace() {
		return intSelectedRace;
	}

	public void setIntSelectedRace(int intSelectedRace) {
		this.intSelectedRace = intSelectedRace;
	}

	public int getSelectedseize() {
		return selectedseize;
	}

	public void setSelectedseize(int selectedseize) {
		this.selectedseize = selectedseize;
	}

	public String getSelectedStarting() {
		return selectedStarting;
	}

	public void setSelectedStarting(String selectedStarting) {
		this.selectedStarting = selectedStarting;
	}

	public String getSelectedEnding() {
		return selectedEnding;
	}

	public void setSelectedEnding(String selectedEnding) {
		this.selectedEnding = selectedEnding;
	}

	public int getSelectedarea() {
		return selectedarea;
	}

	public void setSelectedarea(int selectedarea) {
		this.selectedarea = selectedarea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
