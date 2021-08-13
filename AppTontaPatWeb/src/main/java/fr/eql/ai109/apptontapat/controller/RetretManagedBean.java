package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;

@ManagedBean(name = "mbRetret")
@SessionScoped
public class RetretManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Retret retret ;
	private List<Retret> retretsList ;
	
	@EJB
	private RetretIBusiness retretIBusiness ;
	
	
	
	
	public List<Retret> getAllRetret() {
		retretsList = retretIBusiness.extraireToutLesRetret();
		return retretsList ; 
	}
	
	

	public Retret getRetret() {
		return retret;
	}

	public void setRetret(Retret retret) {
		this.retret = retret;
	}



	public List<Retret> getRetretsList() {
		return retretsList;
	}



	public void setRetretsList(List<Retret> retretsList) {
		this.retretsList = retretsList;
	} 

	
	
}
