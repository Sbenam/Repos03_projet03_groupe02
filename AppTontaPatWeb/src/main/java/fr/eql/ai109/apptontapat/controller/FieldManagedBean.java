package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.CompositionIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;
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
	private String selectedSlope;
	private List<String> grasses = new ArrayList<String>();
	private String selectedGrass;
	private List<String> humidities = new ArrayList<String>();
	private String selectedHumidity;
	private List<String> Veggies = new ArrayList<String>();
	private String selectedVeggy;
	private List<String> compos = new ArrayList<String>();
	private String selectedCompo;
	private List<String> retrets = new ArrayList<String>();
	private String selectedRetret;
	private Retret retretvalue;
	private ZipCode zipID;
	private String zipcode;

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
	private ZipCodeIBusiness zipCodeIBusiness;
	@EJB
	private RetretIBusiness retretIBusiness;

	@PostConstruct
	public void init() {
		slopes = getAllSlopeLabels();
		grasses = getAllGrassLabels();
		humidities = getAllHumidityLabels();
		Veggies = getAllVeggyLabels();
		compos = getAllCompoLabels();
		retrets = getAllRetretLabels();
		zipID = getCityWithZipCodeID();
		getCityWithZipCodeCode(zipcode);
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

	public List<Field> getAllByIdAccount(int id) {
		allField = getAllFieldByIdAccount(id);
//		selectField = new Field();
		if (selectField.getAccount() == null & allField != null) {
			selectField = allField.get(0);
			System.out.println("------------selecfield reprend la valeur du terrain 0----------------");
		}
		return allField;
	}

	public List<String> getAllSlopeLabels() {
		return slopeIBusiness.extraireToutLesSlopesLabels();
	}

	public List<String> getAllGrassLabels() {
		return grassIBusiness.extraireToutLesGlassHeightLabels();
	}

	public List<String> getAllHumidityLabels() {
		return humidityIBusiness.extraireToutLesHumidityLabels();
	}

	public List<String> getAllVeggyLabels() {
		return veggyIBusiness.extraireToutesLesVegetationLabels();
	}

	public List<String> getAllCompoLabels() {
		return compoIBusiness.extraireToutesLesCompositionLabels();
	}

	public List<String> getAllRetretLabels() {
		return retretIBusiness.extraireToutLesRetretLabels();
	}

	public ZipCode getCityWithZipCodeCode(String zipCode) {
		return zipCodeIBusiness.extraireZipCodeAvecCodePostale(zipCode);
	}

	public ZipCode getCityWithZipCodeID() {
		return zipCodeIBusiness.extraireIncidentParId(20225);
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
		System.out.println("Valeur tu terrain selectioner mis a jour a  : " + selectIdField);
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
}
