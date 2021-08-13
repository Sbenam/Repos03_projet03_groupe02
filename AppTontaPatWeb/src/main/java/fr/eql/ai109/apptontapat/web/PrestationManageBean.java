package fr.eql.ai109.apptontapat.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ServicePageMBean", eager = true)
@ViewScoped
public class PrestationManageBean implements Serializable{

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String serviceView;
	
	
	
	
	@PostConstruct
	public void init() {
	setServiceView("attente");
	}




	public String getServiceView() {
		return serviceView;
	}




	public void setServiceView(String serviceView) {
		this.serviceView = serviceView;
	}

	
}
