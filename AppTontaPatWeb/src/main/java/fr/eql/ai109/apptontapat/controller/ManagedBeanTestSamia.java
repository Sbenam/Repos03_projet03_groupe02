package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Datum;
import fr.eql.ai109.apptontapat.entity.Enclosure;
import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.entity.GlassHeight;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Humidity;
import fr.eql.ai109.apptontapat.entity.Incident;
import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Rupture;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.Shelter;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.entity.Vegetation;
import fr.eql.ai109.apptontapat.entity.Water;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.CompositionIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.DatumIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.DesactivationIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.EnclosureIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.EvacuateaIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.IncidentIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RaceIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RefusalIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RuptureIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ShelterIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.TakeoutIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.WaterIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;

@ManagedBean(name = "mbTestSamia")
@SessionScoped
public class ManagedBeanTestSamia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ServiceIBusiness a;
	
	public List<Service> getAll() {
		return a.extraireToutesLesPrestations();
	}
	/*public Herd getAll() {
		Herd h = new Herd();
		return a.ajoutTroupeau(new Herd("troupeau féroce"));
	}*/
}
