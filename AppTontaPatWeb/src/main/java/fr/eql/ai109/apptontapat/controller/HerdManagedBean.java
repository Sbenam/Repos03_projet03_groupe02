package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;

@ManagedBean(name = "mbHerd")
@SessionScoped
public class HerdManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private HerdIbusiness herdIBusiness;

	public Herd getHerdByIdAccount(int id) {
		return herdIBusiness.extraireTroupeauParIdAccount(id);
	}
	public List<Herd> getAllHerd() {
		return herdIBusiness.extraireToutLesTroupeaux();
	}
	public List<Herd> getAllHerdByIdAccount(int id) {
		return herdIBusiness.extraireToutLesTroupeauxParIdAccount(id);
	}
	private Herd herd = new Herd();
	private String test;

	@PostConstruct
	public void init() {
	
	}
	
	public void getHerdById(int id) {
		System.out.println("test d'apelle de function get test et id: "+id);
		herd=herdIBusiness.extraireTroupeauParId(id);
	}

	public Herd getHerd() {
		return herd;
	}

	public void setHerd(Herd herd) {
		this.herd = herd;
	}
	

	public String getTest(int id) {
		System.out.println("test d'apelle de function get test et id: "+id);
		return test;
	}



}
