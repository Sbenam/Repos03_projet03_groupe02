package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.TakeoutIBusiness;

@ManagedBean(name = "mbRetret")
@SessionScoped
public class RetretManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Retret retret ;
	private List<Retret> retretsList ;
	private TakeOut takeout ;
	private List<TakeOut> takeoutsList ;
	
	@EJB
	private RetretIBusiness retretIBusiness ;
	@EJB
	private TakeoutIBusiness takeoutIBusiness ; 
	
	
	
	
	public List<Retret> getAllRetret() {
		retretsList = retretIBusiness.extraireToutLesRetret();
		return retretsList ; 
	}
	
	public List<TakeOut> getAllTakeout() {
		takeoutsList = takeoutIBusiness.extraireToutesLesTakeout();
		return takeoutsList ; 
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

	public TakeOut getTakeout() {
		return takeout;
	}

	public void setTakeout(TakeOut takeout) {
		this.takeout = takeout;
	}

	public List<TakeOut> getTakeoutsList() {
		return takeoutsList;
	}

	public void setTakeoutsList(List<TakeOut> takeoutsList) {
		this.takeoutsList = takeoutsList;
	} 

	
	
}
