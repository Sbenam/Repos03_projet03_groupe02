package fr.eql.ai109.apptontapat.controller;

import java.io.IOException;
import java.io.Serializable;
// import java.lang.System.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;
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
	private int nZipcode;
	private ZipCode zipCode;
	private Account account;
	private String birth;
	private Date dBirth;
	private int phone;

	@EJB
	private AccountIBusiness accountIBusiness;

	@EJB
	private ZipCodeIBusiness zipcodeibusiness;

	public void inscription(Account account) {
		setAccount((accountIBusiness.inscription(account) != null) ? account : null);
	}

	public String connect() {
		String forward = null;
		account = accountIBusiness.connection(email, password);
		if (account != null) {
			forward = "simpleArch.xhtml?faces-redirection=true";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			try {
				ec.redirect(ec.getRequestContextPath() + "/simpleArch.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)", "Identifiant et/ou mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
		}
		return forward;
	}

	public String addAccount() {
		String forward = null;
		account = new Account();
		zipCode = zipcodeibusiness.extraireZipCodeAvecCodePostale(String.valueOf(nZipcode));

		account.setSurName(name);
		account.setName(surNname);
		account.setAdress(adress);
		account.setPhone("0" + phone);
		account.setEmail(email);
		account.setPassword(password);
		account.setBirth(dBirth);
		account.setRegistration(new Date());
		account.setZipcode(zipCode);

		if (account != null) {
			inscription(account);
			forward = "/simpleArch.xhtml?faces-redirection=true";
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

	public void verifFormP(PageManageBean managedBean) {
		System.out.println("Entrer dans la phase n°2");

		boolean Rsurname = Pattern.matches("[a-zA-Z]{2,}", surNname);
		boolean Rname = Pattern.matches("[a-zA-Z]{2,}", name);
		boolean Rphone = Pattern.matches(
				"^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$",
				"0" + Integer.toString(phone));

		try {
			dBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			System.out.println("post format dbirth: " + dBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("surname: " + Rsurname + " Name: " + Rname + " phone: " + Rphone);
		// si surname , name et phone ok
		if (Rsurname & Rname & Rphone) {
			managedBean.setPage2("inscription3");

		} else {
			if (!Rsurname) {
				managedBean.setPage2("inscription2");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nom de famille incorrect ",
						"Format du nom incorrect");
				FacesContext.getCurrentInstance().addMessage("loginForm2:nameInput", facesMessage);
			}
			if (!Rname) {
				managedBean.setPage2("inscription2");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Prenom incorrect ",
						"Format du prénom incorrect");
				FacesContext.getCurrentInstance().addMessage("loginForm2:surnameInput", facesMessage);
			}
			if (!Rphone) {
				managedBean.setPage2("inscription2");
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Telephone incorrect ",
						"Format du telephone incorrect");
				FacesContext.getCurrentInstance().addMessage("loginForm2:phone-input", facesMessage);
			}
		}

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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerif() {
		return passwordVerif;
	}

	public void setPasswordVerif(String passwordVerif) {
		this.passwordVerif = passwordVerif;
	}

	public String getCgu() {
		return cgu;
	}

	public void setCgu(String cgu) {
		this.cgu = cgu;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getnZipcode() {
		return nZipcode;
	}

	public void setnZipcode(int nZipcode) {
		this.nZipcode = nZipcode;
	}
}
