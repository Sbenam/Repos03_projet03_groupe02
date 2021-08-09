package fr.eql.ai109.apptontapat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="mbZipCode")
@ViewScoped
public class ZipCodeManageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> cities = new ArrayList<String>();
	private String selectedCity ;
	
	@PostConstruct
	public void init() {
		
	
		
		this.cities.add("Paris");
		this.cities.add("Tours");
		this.cities.add("Bordeaux");
		
		
		
	}
	

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}


	
	
}
