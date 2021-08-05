package fr.eql.ai109.apptontapat.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "testManageBean", eager = true)
@ViewScoped
public class testManageBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String page;
	private String page2;

	@PostConstruct
	public void init() {
		setPage("test2"); // Default include.
		setPage2("blank");
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		System.out.println("page: "+page);
	}

	public String getPage2() {
		return page2;
	}

	public void setPage2(String page2) {
		this.page2 = page2;
	}

}
