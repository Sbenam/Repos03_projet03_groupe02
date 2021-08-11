package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.ibusiness.CompositionIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Field field = new Field();
	private List<String> slopes = new ArrayList<String>();
	private String selectedSlope ;
	private List<String> grasses = new ArrayList<String>();
	private String selectedGrass ;
	private List<String> humidities = new ArrayList<String>();
	private String selectedHumidity ;
	private List<String> Veggies = new ArrayList<String>();
	private String selectedVeggy ;
	private List<String> compos = new ArrayList<String>();
	private String selectedCompo ;
	
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
	
	@PostConstruct
	public void init() {
		slopes = getAllSlopeLabels() ;
		grasses = getAllGrassLabels();
		humidities = getAllHumidityLabels() ;
		Veggies = getAllVeggyLabels() ;
		compos = getAllCompoLabels();
		
	}
	
	
	public List<String> getAllSlopeLabels() {
		return slopeIBusiness.extraireToutLesSlopesLabels();
	}
	public List<String> getAllGrassLabels() {
		return grassIBusiness.extraireToutLesGlassHeightLabels();
	}
	public List<String> getAllHumidityLabels() {
		return humidityIBusiness.extraireToutLesHumidityLabels() ;
	}
	public List<String> getAllVeggyLabels() {
		return veggyIBusiness.extraireToutesLesVegetationLabels();
	}
	public List<String> getAllCompoLabels() {
		return compoIBusiness.extraireToutesLesCompositionLabels();
	}
	
	
	
	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	
	public Field getFieldById(int id) {
		return fieldIBusiness.extraireTerrainParId(id);
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
}
