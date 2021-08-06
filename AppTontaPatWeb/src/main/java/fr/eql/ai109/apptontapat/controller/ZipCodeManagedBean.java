package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;

@ManagedBean(name = "mbZipCode")
@SessionScoped
public class ZipCodeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ZipCodeIBusiness zipcodeibusiness;
	
	public List<String> getAllCity(){
		return zipcodeibusiness.getAllBuCity();
	}
	public List<ZipCode> getAll(){
		return zipcodeibusiness.getAllBu();
	}
	

}
