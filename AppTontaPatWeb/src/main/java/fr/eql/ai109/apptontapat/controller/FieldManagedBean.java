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

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.entity.Enclosure;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.entity.GlassHeight;
import fr.eql.ai109.apptontapat.entity.Humidity;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Shelter;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.entity.Vegetation;
import fr.eql.ai109.apptontapat.entity.Water;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.CompositionIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.EnclosureIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ShelterIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.WaterIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;
import fr.eql.ai109.apptontapat.web.PageManageBean;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Field> allField = new ArrayList<Field>();
	private Field selectField = new Field();
	private int selectIdField;
	private Field field = new Field();
	private List<String> slopes = new ArrayList<String>();
	private String selectedSlope ;
	private Slope slopevalue;
	private int intSelectedSlope;
	private List<String> grasses = new ArrayList<String>();
	private String selectedGrass;
	private int intSelectedGrass;
	private List<String> humidities = new ArrayList<String>();
	private String selectedHumidity;
	private int intSelectedHumidity;
	private List<String> Veggies = new ArrayList<String>();
	private String selectedVeggy;
	private int intSelectedVeggy;
	private List<String> compos = new ArrayList<String>();
	private String selectedCompo;
	private List<String> enclosures = new ArrayList<String>();
	private String selectedEnclosure;
	private List<String> waters = new ArrayList<String>();
	private String selectedWater;
	private List<String> shelters = new ArrayList<String>();
	private int intSelectedCompo;
	private List<String> retrets = new ArrayList<String>();
	private Retret retretvalue;
	private int selectEnclosure;
	private String selectWater;
	private int intselectWater;
	private ZipCode zipID;
	private String zipcode;
	private String selectedRetret;
	private String selectedShelter;
	private int intSelectedShelter;
	private String selectedStarting;
	private String selectedEnding;
	Date dstarting;
	Date dending;
	private String selectedName;
	private String selectedAdress;
	private int selectedSurface;

	@EJB
	private FieldIBusiness fieldIBusiness;
	@EJB
	private SlopeIbusiness slopeIBusiness;
	@EJB
	private GlassHeightIbusiness grassIBusiness;
	@EJB
	private HumidityIBusiness humidityIBusiness;
	@EJB
	private VegetationIBusiness veggyIBusiness;
	@EJB
	private CompositionIBusiness compoIBusiness;
	@EJB
	private EnclosureIbusiness enclosureIBusiness ;
	@EJB
	private ZipCodeIBusiness zipCodeIBusiness;
	@EJB
	private RetretIBusiness retretIBusiness;
	@EJB
	private EnclosureIbusiness enclosureIbusiness;
	@EJB
	private WaterIBusiness waterIBusiness;
	@EJB
	private ShelterIBusiness shelterIBusiness;


	@PostConstruct
	public void init() {
		slopes = slopeIBusiness.extraireToutLesSlopesLabels();
		grasses =  grassIBusiness.extraireToutLesGlassHeightLabels();
		humidities = humidityIBusiness.extraireToutLesHumidityLabels() ;
		Veggies = veggyIBusiness.extraireToutesLesVegetationLabels();
		compos = compoIBusiness.extraireToutesLesCompositionLabels();
		enclosures = enclosureIBusiness.extraireToutesLesEnclosuresLabels();
		waters = waterIBusiness.extraireToutLesWaterLabels();
		shelters = shelterIBusiness.extraireToutLesSheltersLabels();
		retrets = retretIBusiness.extraireToutLesRetretLabels();
		zipID = getCityWithZipCodeID();
		getCityWithZipCodeCode(zipcode);
	}

	public List<Shelter> getListShelter() {
		return shelterIBusiness.extraireToutLesShelters();
	}

	public List<Water> getListWater() {
		return waterIBusiness.extraireToutLesWater();
	}

	public List<Enclosure> getListEnclosure() {
		return enclosureIbusiness.extraireToutesLesEnclosures();
	}

	public List<Composition> getListComposition() {
		return compoIBusiness.extraireToutesLesComposition();
	}

	public List<Vegetation> getListVegetation() {
		return veggyIBusiness.extraireToutesLesVegetation();
	}

	public List<Humidity> getListHumidity() {
		return humidityIBusiness.extraireToutLesHumidity();
	}

	public List<Slope> getListSlope() {
		return slopeIBusiness.extraireToutLesSlopes();
	}

	public List<GlassHeight> getListGrass() {
		return grassIBusiness.extraireToutLesGlassHeight();
	}

	public List<Shelter> getShelter() {
		return shelterIBusiness.extraireToutLesShelters();
	}

	public List<Water> getWater() {
		return waterIBusiness.extraireToutLesWater();
	}

	public List<Enclosure> getEnclosure() {
		return enclosureIbusiness.extraireToutesLesEnclosures();
	}

	public void addFieldP3(PageManageBean p, AccountManagedBean mbaccount) {
		field.setAccount(mbaccount.getAccount());
		field.setAdding(new Date());

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
		field.setStarting(dstarting);
		field.setEnding(dending);
		fieldIBusiness.ajoutTerrain(field);
		selectField = field;
		p.setPage2("blank");
		p.setPage("terrain_detail");
	}

	public void addFieldP2(PageManageBean p) {
		field.setShelter(getListShelter().get(intSelectedShelter));
		field.setWater(getListWater().get(intselectWater));
		field.setEnclosure(getListEnclosure().get(selectEnclosure));
		field.setComposition(getListComposition().get(intSelectedCompo));
		field.setVegetation(getListVegetation().get(intSelectedVeggy));
		field.setHumidity(getListHumidity().get(intSelectedHumidity));
		field.setSlope(getListSlope().get(intSelectedSlope));
		field.setGlassheight(getListGrass().get(intSelectedGrass));
		p.setPage2("addfield3");
	}

	public void addFieldP1(PageManageBean p) {
		System.out.println("zipcode : " + zipcode);
		field.setAdress(selectedAdress);
		field.setName(selectedName);
		field.setZipcode(getCityWithZipCodeCode(zipcode));
		field.setSurface(selectedSurface);
		field.setPhoto("https://cdn.pixabay.com/photo/2021/07/11/10/39/fantasy-6403406_960_720.jpg");
		p.setPage2("addfield2");
	}

	public void shearchForField(PageManageBean pageManageBean) {
		pageManageBean.setPage2("blank");
		pageManageBean.setPage("research");
		selectField = fieldIBusiness.extraireTerrainParId(selectIdField);
	}


	public void updateField(PageManageBean pageManagedBean, Field field) {
		selectField = field;
		pageManagedBean.setPage("updatefield");

	}

	public void getFieldDetail(PageManageBean pageManagedBean, Field field) {
		selectField = field;
		pageManagedBean.setPage("terrain_detail");

	}

	public void cleanField() {
		field = new Field();
	}

	public List<Field> getAllByIdAccount(int id) {
		allField = getAllFieldByIdAccount(id);
		if (selectField.getAccount() == null & allField != null) {
			selectField = allField.get(0);
		}
		return allField;
	}
	
//	public String getCityWithZipCode(String zipCode) {
//		return zipCodeIBusiness.extraireVilleAvecCodePostale(zipCode) ;
//	}
	public ZipCode getCityWithZipCodeCode(String zipCode) {
		return zipCodeIBusiness.extraireZipCodeAvecCodePostale(zipCode);
    }	

	public ZipCode getCityWithZipCodeID() {
		return zipCodeIBusiness.extraireIncidentParId(20225);
	}

	public String maj(List<Slope> slopesList) {
		
		slopevalue = slopesList.get(Integer.parseInt(selectedSlope)-1) ;
		System.out.println("valeur de slopevalue ----------------------------" + slopevalue);
		System.out.println("valeur de selectedSlope ----------------------------" + selectedSlope);
		field.setSlope(slopevalue);
//		field.setGlassheight();
//		field.setHumidity();
//		field.setVegetation();
//		field.setComposition();
//		field.setEnclosure();
//		field.setShelter();
//		field.setName();
//		field.setAdress();
//		field.setZipcode();
//		field.setSurface();
//		field.setDescription();
//		field.setStarting();
//		field.setEnding();
		fieldIBusiness.mettreAJourUnTerrain(field);
		return "simpleArch.xhtml"; 
	}
	
	public String supprimer(List<Retret> retretsList) {

		retretvalue = retretsList.get(Integer.parseInt(selectedRetret) - 1);
		field.setWithdraw(new Date());
		field.setRetret(retretvalue);
		fieldIBusiness.mettreAJourUnTerrain(field);
		return "simpleArch.xhtml";
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void getFieldById(int id) {
		field = fieldIBusiness.extraireTerrainParId(id);
	}

	public Field getFieldByIdAccount(int id) {
		return fieldIBusiness.extraireTerrainParIdAccount(id);
	}

	public List<Field> getAllField() {
		return fieldIBusiness.extraireToutLesTerrain();
	}

	public List<Field> getAllFieldByIdAccount(int id) {
		return fieldIBusiness.extraireToutLesTerrainParIdAccount(id);
	}

	public List<String> getSlopes() {
		return slopes;
	}

	public void setSlopes(List<String> slopes) {
		this.slopes = slopes;
	}

	public String getSelectedSlope() {
		return selectedSlope;
	}

	public void setSelectedSlope(String selectedSlope) {
		this.selectedSlope = selectedSlope;
	}

	public List<String> getGrasses() {
		return grasses;
	}

	public void setGrasses(List<String> grasses) {
		this.grasses = grasses;
	}

	public String getSelectedGrass() {
		return selectedGrass;
	}

	public void setSelectedGrass(String selectedGrass) {
		this.selectedGrass = selectedGrass;
	}

	public String getSelectedHumidity() {
		return selectedHumidity;
	}

	public void setSelectedHumidity(String selectedHumidity) {
		this.selectedHumidity = selectedHumidity;
	}

	public List<String> getVeggies() {
		return Veggies;
	}

	public void setVeggies(List<String> veggies) {
		Veggies = veggies;
	}

	public String getSelectedVeggy() {
		return selectedVeggy;
	}

	public void setSelectedVeggy(String selectedVeggy) {
		this.selectedVeggy = selectedVeggy;
	}

	public List<String> getCompos() {
		return compos;
	}

	public void setCompos(List<String> compos) {
		this.compos = compos;
	}

	public String getSelectedCompo() {
		return selectedCompo;
	}

	public void setSelectedCompo(String selectedCompo) {
		this.selectedCompo = selectedCompo;
	}

	public List<String> getHumidities() {
		return humidities;
	}

	public void setHumidities(List<String> humidities) {
		this.humidities = humidities;
	}

	public List<String> getRetrets() {
		return retrets;
	}

	public void setRetrets(List<String> retrets) {
		this.retrets = retrets;
	}

	public String getSelectedRetret() {
		return selectedRetret;
	}

	public void setSelectedRetret(String selectedRetret) {
		this.selectedRetret = selectedRetret;
	}

	public Retret getRetretvalue() {
		return retretvalue;
	}

	public void setRetretvalue(Retret retretvalue) {
		this.retretvalue = retretvalue;
	}

	public ZipCode getZipID() {
		return zipID;
	}

	public void setZipID(ZipCode zipID) {
		this.zipID = zipID;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Field getSelectField() {
		return selectField;
	}

	public void setSelectField(Field selectField) {
		this.selectField = selectField;
	}

	public void setAllField(List<Field> allField) {
		this.allField = allField;
	}

	public int getSelectIdField() {
		return selectIdField;
	}

	public void setSelectIdField(int selectIdField) {
		this.selectIdField = selectIdField;
	}

	public List<String> getEnclosures() {
		return enclosures;
	}

	public void setEnclosures(List<String> enclosures) {
		this.enclosures = enclosures;
	}

	public String getSelectedEnclosure() {
		return selectedEnclosure;
	}

	public void setSelectedEnclosure(String selectedEnclosure) {
		this.selectedEnclosure = selectedEnclosure;
	}

	public List<String> getWaters() {
		return waters;
	}

	public void setWaters(List<String> waters) {
		this.waters = waters;
	}

	public String getSelectedWater() {
		return selectedWater;
	}

	public void setSelectedWater(String selectedWater) {
		this.selectedWater = selectedWater;
	}

	public List<String> getShelters() {
		return shelters;
	}

	public void setShelters(List<String> shelters) {
		this.shelters = shelters;
	}

	public int getSelectEnclosure() {
		return selectEnclosure;
	}

	public void setSelectEnclosure(int selectEnclosure) {
		this.selectEnclosure = selectEnclosure;
	}

	public String getSelectWater() {
		return selectWater;
	}

	public void setSelectWater(String selectWater) {
		this.selectWater = selectWater;
	}

	public String getSelectedShelter() {
		return selectedShelter;
	}

	public void setSelectedShelter(String selectedShelter) {
		this.selectedShelter = selectedShelter;
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

	public int getIntSelectedGrass() {
		return intSelectedGrass;
	}

	public void setIntSelectedGrass(int intSelectedGrass) {
		this.intSelectedGrass = intSelectedGrass;
	}

	public int getIntSelectedSlope() {
		return intSelectedSlope;
	}

	public void setIntSelectedSlope(int intSelectedSlope) {
		this.intSelectedSlope = intSelectedSlope;
	}

	public int getIntselectWater() {
		return intselectWater;
	}

	public void setIntselectWater(int intselectWater) {
		this.intselectWater = intselectWater;
	}

	public int getIntSelectedVeggy() {
		return intSelectedVeggy;
	}

	public void setIntSelectedVeggy(int intSelectedVeggy) {
		this.intSelectedVeggy = intSelectedVeggy;
	}

	public int getIntSelectedHumidity() {
		return intSelectedHumidity;
	}

	public void setIntSelectedHumidity(int intSelectedHumidity) {
		this.intSelectedHumidity = intSelectedHumidity;
	}

	public int getIntSelectedCompo() {
		return intSelectedCompo;
	}

	public void setIntSelectedCompo(int intSelectedCompo) {
		this.intSelectedCompo = intSelectedCompo;
	}

	public int getIntSelectedShelter() {
		return intSelectedShelter;
	}

	public void setIntSelectedShelter(int intSelectedShelter) {
		this.intSelectedShelter = intSelectedShelter;
	}

	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public String getSelectedAdress() {
		return selectedAdress;
	}

	public void setSelectedAdress(String selectedAdress) {
		this.selectedAdress = selectedAdress;
	}

	public int getSelectedSurface() {
		return selectedSurface;
	}

	public void setSelectedSurface(int selectedSurface) {
		this.selectedSurface = selectedSurface;
	}
}
