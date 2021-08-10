package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;

@ManagedBean(name = "mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Field field;
	private List<Herd> herds;
	private List<ZipCode> zipcodes;
	
	// TODO vin retrait de init()
	@PostConstruct
	public void init() {
		herds = serviceIBusiness.search(9.26560816948, 41.9210089906);
		System.err.println(herds.size());
	}
	
	@EJB
	private ServiceIBusiness serviceIBusiness;

	
	public List<ZipCode> search(ZipCode zipcode) {
		zipcodes = null;
		
		zipcodes = serviceIBusiness.search(field);
		
		return zipcodes;
	}

//	public List<Herd> search(Field field) {
//		herds = null;
//		
//		herds = serviceIBusiness.search(field);
//		
//		return herds;
//	}

	
	public List<Herd> getHerds() {
		return herds;
	}

	public void setHerds(List<Herd> herds) {
		this.herds = herds;
	}
	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}
