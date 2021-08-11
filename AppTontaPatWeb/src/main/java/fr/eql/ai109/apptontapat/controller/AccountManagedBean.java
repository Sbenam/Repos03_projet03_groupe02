package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.Date;
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

	private String name;
	private String surNname;
	private String adress;
	private String cgu;
	private String email;
	private String password;
	private String passwordVerif;
	private ZipCode zipCode;
	private Account account;
	private Date birth;
	private int phone;

	@EJB
	private AccountIBusiness accountIBusiness;

	public void inscription(Account account) {
		setAccount((accountIBusiness.inscription(account) != null) ? account : null);
	}

	public String connect() {
		String forward = null;
		account = accountIBusiness.connection(email, password);
		if (account != null) {
			forward = "simpleArch.xhtml?faces-redirection=true";
		} else {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)", "Identifiant et/ou mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
		}
		return forward;
	}

	public void verifmail(PageManageBean managedBean) {

		boolean RMailV = Pattern.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email);
		boolean Rpassword = Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", password);


		if (RMailV && Rpassword && passwordVerif.equals(password)) {
			managedBean.setPage2("inscription2");
		} else {

			if (RMailV) {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Identifiant et/ou mot de passe incorrect(s)", "mot de passe incorrect(s)");
				FacesContext.getCurrentInstance().addMessage("loginForm:password-input", facesMessage);

			}
			if (Rpassword && !RMailV) {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Email incorrect ",
						"Email incorrect : " + email);
				FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);

			}
			if (!passwordVerif.equals(password)) {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Identifiant et/ou mot de passe incorrect(s)", "Les deux mots de passe doivent être similaire");
				FacesContext.getCurrentInstance().addMessage("loginForm:repeatpasswordinput", facesMessage);

			} else {
				managedBean.setPage2("inscription1");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Identifiant et/ou mot de passe incorrect(s)", "Mauvais format de mot de passe");
				FacesMessage facesMessageMail = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Identifiant et/ou mot de passe incorrect(s)", "Email mauvais format");
				FacesContext.getCurrentInstance().addMessage("loginForm:password-input", facesMessage);
				FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessageMail);
			}
		}

	}

	public void verifFormP2(PageManageBean managedBean){
		System.out.println("Entrer dans la phase n°2");
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
