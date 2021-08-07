package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;

@ManagedBean(name = "mbAccount")
@SessionScoped
public class AccountManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// TODO vin
	private String name;
	private String surNname;
	private String adress;
	private String email;
	private String password;
	private ZipCode zipCode;
	private Account account;
	
	@EJB
	private AccountIBusiness accountIBusiness;
	

	public String inscription(Account account) {
		
		return (accountIBusiness.inscription(account) != null) ? "" : "" ;

	}

	public String connect() {
		String forward = null;
		account = accountIBusiness.connection(email, password);
		if (account != null) {
			forward = "" /*"/ConnectedPage.xhtml?faces-redirection=true"*/;
		} else {
//			FacesMessage facesMessage = new FacesMessage(
//					FacesMessage.SEVERITY_WARN,
//					"Identifiant et/ou mot de passe incorrect(s)",
//					"Identifiant et/ou mot de passe incorrect(s)"
//					);
//			FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);
//			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
			forward = "" /*"/login.xhtml?faces-redirection=false"*/;
		}
		return forward;
	}

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurNname() {
		return surNname;
	}



	public void setSurNname(String surNname) {
		this.surNname = surNname;
	}



	public ZipCode getZipCode() {
		return zipCode;
	}



	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}
	

}
