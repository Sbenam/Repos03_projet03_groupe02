package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Enclosure;
import fr.eql.ai109.apptontapat.entity.GlassHeight;
import fr.eql.ai109.apptontapat.entity.Humidity;
import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.entity.Shelter;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.entity.Vegetation;
import fr.eql.ai109.apptontapat.entity.Water;
import fr.eql.ai109.apptontapat.ibusiness.EnclosureIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RaceIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ShelterIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.WaterIBusiness;

@ManagedBean(name = "mbTestSamia")
@SessionScoped
public class ManagedBeanTestSamia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	SpecieIBusiness specieIBusiness;
	
	public List<Specie> getAll() {
		return specieIBusiness.extraireToutLesSpecies();
	}
}
