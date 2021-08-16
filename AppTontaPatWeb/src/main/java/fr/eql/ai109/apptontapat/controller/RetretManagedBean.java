package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.ibusiness.EvacuateaIBusiness;
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
	private EvacuateA evacuatea ;
	private List<EvacuateA> evacuateasList ;
	
	@EJB
	private RetretIBusiness retretIBusiness ;
	@EJB
	private TakeoutIBusiness takeoutIBusiness ; 
	@EJB
	private EvacuateaIBusiness evacuateaIBusiness ; 
	
	
	
	public List<Retret> getAllRetret() {
		retretsList = retretIBusiness.extraireToutLesRetret();
		return retretsList ; 
	}
	
	public List<TakeOut> getAllTakeout() {
		takeoutsList = takeoutIBusiness.extraireToutesLesTakeout();
		return takeoutsList ; 
	}
	public List<EvacuateA> getAllEvacuatea() {
		evacuateasList = evacuateaIBusiness.extraireToutesLesEvacuateA() ;
		System.out.println("evacuatea------------" + evacuateasList);
		return evacuateasList ; 
	
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

	public EvacuateA getEvacuatea() {
		return evacuatea;
	}

	public void setEvacuatea(EvacuateA evacuatea) {
		this.evacuatea = evacuatea;
	}

	public List<EvacuateA> getEvacuateasList() {
		return evacuateasList;
	}

	public void setEvacuateasList(List<EvacuateA> evacuateasList) {
		this.evacuateasList = evacuateasList;
	} 

	
	
}
