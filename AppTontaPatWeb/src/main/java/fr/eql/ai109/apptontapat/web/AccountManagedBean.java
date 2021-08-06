package fr.eql.ai109.apptontapat.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;

@ManagedBean(name = "mbAccount")
@SessionScoped
public class AccountManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// TODO vin
	private String name;
	private String surNname;
	private Account account;
	
	@EJB
	private AccountIBusiness accountIBusiness;
	
	public String inscription() {
		// TODO vin
		return "";
	}
	
}
