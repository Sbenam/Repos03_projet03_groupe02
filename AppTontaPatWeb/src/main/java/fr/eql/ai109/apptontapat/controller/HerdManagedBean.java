package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;

@ManagedBean(name = "mbHerd")
@SessionScoped
public class HerdManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	private HerdIbusiness herdIBusiness;
	private Herd herd = herdIBusiness.extraireTroupeauParId(2);
	public Herd getHerdById(int id) {
		return herdIBusiness.extraireTroupeauParId(id);
	}
	public Herd getHerd() {
		return herd;
	}
	public void setHerd(Herd herd) {
		this.herd = herd;
	}
}
