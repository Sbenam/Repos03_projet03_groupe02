package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;

@ManagedBean(name="mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	private Field field;
	private List<Herd> herds;
	private Herd herd;
	private List<Float> dists;
	
	
	@EJB
	private ServiceIBusiness serviceIBusiness;

	@EJB
	private FieldIBusiness fieldIBusiness;

	
	public List<Service> getAllByIdAccount(int id) {
		return serviceIBusiness.getAllByIdAccount(id);
	}
	
	public List<Herd> search(Field field) {
		return serviceIBusiness.search(field);
	}
	
	public List<Herd> searchTest() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>"+fieldIBusiness.extraireTerrainParId(15).getZipcode().getLatitude());
		herds = serviceIBusiness.search(fieldIBusiness.extraireTerrainParId(15));
		return herds;
	}

	public List<Float> distance() {
		System.out.println("\n-------------------->"+fieldIBusiness.extraireTerrainParId(15).getZipcode().getLatitude());
		dists = serviceIBusiness.distanceBU(fieldIBusiness.extraireTerrainParId(15));
		return dists;
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

	public List<Float> getDists() {
		return dists;
	}

	public void setDists(List<Float> dists) {
		this.dists = dists;
	}


}
