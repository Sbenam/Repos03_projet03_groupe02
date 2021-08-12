package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;

@ManagedBean(name="mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Field field;
	private List<Herd> herds;
	private Herd herd;
//	private List<ZipCode> zipcodes;
	
	// TODO vin retrait de init()
	
	@EJB
	private ServiceIBusiness serviceIBusiness;

	@EJB
	private FieldIBusiness fieldIBusiness;

//	public List<ZipCode> search(ZipCode zipcode) {
//		zipcodes = null;
//		
//		zipcodes = serviceIBusiness.search(field);
//		
//		return zipcodes;
//	}

	@PostConstruct
	public void init() {
		Field f = fieldIBusiness.extraireTerrainParId(3);
		System.out.println("\n-----------------"+f+"------------------");
		herds = serviceIBusiness.search(f);
		System.out.println("\n-----------------"+herds.size()+"------------------");
		System.out.println("\n-----------------"+herds.get(0).getName()+"------------------");
		System.out.println("\n-----------------"+herds.get(0).getZipcode().getLabel()+"------------------");
	}

	public List<Herd> search(Field field) {
		return serviceIBusiness.search(field);
	}
	
	public List<Herd> search2() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>"+fieldIBusiness.extraireTerrainParId(22).getZipcode().getLatitude());
		return serviceIBusiness.search(fieldIBusiness.extraireTerrainParId(22));
	}

	
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

	public Herd getHerd() {
		return herd;
	}

	public void setHerd(Herd herd) {
		this.herd = herd;
	}


}
