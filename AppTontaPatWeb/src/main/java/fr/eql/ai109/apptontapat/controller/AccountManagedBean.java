package fr.eql.ai109.apptontapat.controller;

import java.io.IOException;
import java.io.Serializable;
// import java.lang.System.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.EvacuateaIBusiness;
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
	private String description;
	private int nZipcode;
	private ZipCode zipCode;
	private Account account;
	private String birth;
	private Date dBirth;
	private int phone;
	private List<String> evacuateas = new ArrayList<String>();
	private String selectedEvacuatea ;
	private EvacuateA evacuateavalue ;
	private String selectedZipcode;
	private List<Field> fields = new ArrayList<Field>();
	private List<Service> waitserviceFields = new ArrayList<Service>();
	private List<Service> encourServiceFields = new ArrayList<Service>();
	private List<Service> finishServiceFields = new ArrayList<Service>();
	private List<Service> refuseServiceFields = new ArrayList<Service>();
	private List<Service> ruptureServiceFields = new ArrayList<Service>();
	private List<Service> waitserviceHerds = new ArrayList<Service>();
	private List<Service> encourServiceHerds = new ArrayList<Service>();
	private List<Service> finishServiceHerds = new ArrayList<Service>();
	private List<Service> refuseServiceHerds = new ArrayList<Service>();
	private List<Service> ruptureServiceHerds = new ArrayList<Service>();
	private List<Herd> herds = new ArrayList<Herd>();
	
	
	@EJB
	private AccountIBusiness accountIBusiness;
	@EJB
	private ZipCodeIBusiness zipcodeibusiness;
	@EJB
	private EvacuateaIBusiness evacuateaIBusiness ; 
	
	
	@PostConstruct
	private void init() {
		evacuateas = getAllEvacuateaLabels();
	}
	
	
	public List<String> getAllEvacuateaLabels() {
		return evacuateaIBusiness.extraireToutesLesEvacuateALabels();
	}

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
	
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.invalidate();
		email = "";
		password = "";
		account = new Account();
		return "/login.xhtml?faces-redirection=true";
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
	

	public String maj() {
		List<ZipCode> zipcodesList = zipcodeibusiness.getAllBu();
		zipCode = zipcodesList.get(Integer.parseInt(selectedZipcode)-1) ;
		System.out.println("valeur de zipCode ----------------------------" + zipCode);
		System.out.println("valeur de selectedZipcode ----------------------------" + selectedZipcode);
		account.setZipcode(zipCode);
    	System.out.println("mon name account----------------" + name);
    	System.out.println("mon surNname account----------------" + surNname);
    	System.out.println("mon phone account----------------" + phone);
    	System.out.println("mon dBirth account----------------" + dBirth);
    	System.out.println("mon email account----------------" + email);
    	System.out.println("mon password account----------------" + password);
    	System.out.println("mon adress account----------------" + adress);
    	System.out.println("mon description account----------------" + description);
		accountIBusiness.mettreAjourUnCompte(account) ;
		return "simpleArch.xhtml"; 
	}
	
	public String supprimer(List<EvacuateA> evacuateasList) {
	
		evacuateavalue = evacuateasList.get(Integer.parseInt(selectedEvacuatea)-1) ;
		account.setWithdraw(new Date());
		account.setEvacuateA(evacuateavalue);
		accountIBusiness.mettreAjourUnCompte(account) ;
		return "simpleArch.xhtml"; 
	}
	
	public void getAccountById(int id) {
		account = new Account();
		account = accountIBusiness.extraireCompteAvecId(id);
		System.out.println("mon id account----------------" + id);
		System.out.println("mon accountname----------------" + account.getName());
	}
	

	public List<Service> getFieldWaiting(int id) {
		waitserviceFields = accountIBusiness.getFieldWaiting(id);
		return waitserviceFields;
	}

	public List<Service> getFieldRefuse(int id) {
		refuseServiceFields = accountIBusiness.getFieldRefuse(id);
		return refuseServiceFields;
	}

	public List<Service> getFieldEnCour(int id) {
		encourServiceFields = accountIBusiness.getFieldEnCour(id);
		return encourServiceFields;
	}

	public List<Service> getFieldBreak(int id) {
		ruptureServiceFields = accountIBusiness.getFieldBreak(id);
		return ruptureServiceFields;
	}

	public List<Service> getFieldFinish(int id) {
		finishServiceFields = accountIBusiness.getFieldFinish(id);
		return finishServiceFields;
	}
	
	public List<Service> getHerdWaiting(int id) {
		waitserviceHerds = accountIBusiness.getHerdWaiting(id);
		return waitserviceHerds;
	}

	public List<Service> getHerdRefuse(int id) {
		refuseServiceHerds = accountIBusiness.getHerdRefuse(id);
		return refuseServiceHerds;
	}

	public List<Service> getHerdEnCour(int id) {
		encourServiceHerds = accountIBusiness.getHerdEnCour(id);
		return encourServiceHerds;
	}

	public List<Service> getHerdBreak(int id) {
		ruptureServiceHerds = accountIBusiness.getHerdBreak(id);
		return ruptureServiceHerds;
	}

	public List<Service> getHerdFinish(int id) {
		finishServiceHerds = accountIBusiness.getHerdFinish(id);
		return finishServiceHerds;
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

	public List<String> getEvacuateas() {
		return evacuateas;
	}

	public void setEvacuateas(List<String> evacuateas) {
		this.evacuateas = evacuateas;
	}

	public String getSelectedEvacuatea() {
		return selectedEvacuatea;
	}
	
	public void setSelectedEvacuatea(String selectedEvacuatea) {
		this.selectedEvacuatea = selectedEvacuatea;
	}


	public List<Service> getServiceFields() {
		return waitserviceFields;
	}


	public void setServiceFields(List<Service> serviceFields) {
		this.waitserviceFields = serviceFields;
	}

}
