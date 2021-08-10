package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.web.PageManageBean;

@ManagedBean(name = "mbAccount", eager = true)
@SessionScoped
public class AccountManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// TODO: vin
	private String name;
	private String surNname;
	private String adress;
	private String cgu;
	private String email;
	private String password;
	private String passwordVerif;
	private ZipCode zipCode;
	private Account account;

	@EJB
	private AccountIBusiness accountIBusiness;

	public void inscription(Account account) {
		setAccount((accountIBusiness.inscription(account) != null) ? account : null);
	}

	public String connect() {
		// TODO sysout Account
		System.err.println("Passage dans la function connect");
		System.err.println("email : " + email + " password: " + password);
		String forward = null;
		account = accountIBusiness.connection(email, password);
		System.err.println("Account: " + account);
		if (account != null) {
			forward = "/simpleArch.xhtml?faces-redirection=true";
		} else {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)", "Identifiant et/ou mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
			System.out.println("Erreur de connexion");
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

	public String getEmail() {
		System.out.println("email getter: " + email);
		return email;
	}

	public void setEmail(String email) {
		System.out.println("email setter: " + email);
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerif() {
		System.out.println("getter passwordVerif" + passwordVerif);
		return passwordVerif;
	}

	public void setPasswordVerif(String passwordVerif) {
		System.out.println("setter passwordverif: " + passwordVerif);
		this.passwordVerif = passwordVerif;
	}

	public String getCgu() {
		System.out.println("getter cgu: " + cgu);
		return cgu;
	}

	public void setCgu(String cgu) {
		System.out.println("setter cgu : " + cgu);
		this.cgu = cgu;
	}

	public void verifmail(PageManageBean managedBean) {
		System.out.println("verifmail function (email): " +email);
		if (email != null) {
			
			boolean RMailV = Pattern.matches(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email);
			boolean Rpassword = Pattern.matches(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email);
			if (RMailV && Rpassword ) {
				System.out.println("verif mail " + RMailV);
				managedBean.setPage2("inscription2");
			} elseif (Rmail) {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)", "Email incorrect");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
			System.out.println("Erreur de connexion");
				System.out.println("verif mail " + RMailV);
			} elseif (Rpassword) {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)", "mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:password-input", facesMessage);
			System.out.println("Erreur de connexion");
				System.out.println("verif passeword " + Rpassword);
			}
		}
		System.out.println("-------------------------------------------");
	}

}
