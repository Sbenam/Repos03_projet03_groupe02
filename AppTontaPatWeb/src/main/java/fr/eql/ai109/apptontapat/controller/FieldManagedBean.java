package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private FieldIBusiness fieldIBusiness;
	
	
	public Field getFieldById(int id) {
		return fieldIBusiness.extraireTerrainParId(id);
	}
	
	public Field getFieldByIdAccount(int id) {
		return fieldIBusiness.extraireTerrainParIdAccount(id);
	}

	public List<Field> getAllField() {
		return fieldIBusiness.extraireToutLesTerrain();
	}
	
	public List<Field> getAllFieldByIdAccount(int id) {
		return fieldIBusiness.extraireToutLesTerrainParIdAccount(id);
	}
}
