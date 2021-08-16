package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Incident;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.ibusiness.DatumIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.IncidentIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.web.PageManageBean;

@ManagedBean(name = "mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Field field;
	private List<Herd> herds;
	private Herd herd;
	private List<Float> dists;
	private List<Service> servicelist;
	private List<Service> serviceEnAttente = new ArrayList<Service>();
	private List<Service> serviceEnCour = new ArrayList<Service>();
	private List<Service> serviceTerminer = new ArrayList<Service>();
	private List<Service> serviceRefuser = new ArrayList<Service>();
	private Service serviceSelect = new Service();
	private Incident incident;
	private List<Incident> incidentsList ;
	private List<String> datums  = new ArrayList<String>();
	private Integer rating ;


	@EJB
	private ServiceIBusiness serviceIBusiness;

	@EJB
	private FieldIBusiness fieldIBusiness;

	@EJB
	private IncidentIBusiness incidentIBusiness ; 
	@EJB
	private DatumIBusiness datumIBusiness ;
	
	
	
	
	public List<Incident> getAllIncident() {
		incidentsList = incidentIBusiness.extraireToutLesIncident();
		return incidentsList ; 
	}
	public List<String> getAllDatum() {
		datums = datumIBusiness.extraireToutesLesDatumLabels() ;
		return datums ; 
	}
	
	public void getServiceDetail(PageManageBean p,Service s) {
		serviceSelect = s;
		p.setPage("service_detail");
	}

	public List<Service> getAllByIdAccount(int id) {
		if (servicelist != null) {
			serviceClean();
		}
		servicelist = serviceIBusiness.getAllByIdAccountField(id);
		int i =0;
		// repartition des listes
		for (Service service : servicelist) {
			
			// si finished != null  et refus == null ==> Fini
			if (service.getFinished() != null && service.getRefusal() == null && service.getRupture() == null && service.getValidation() != null) {
				System.out.println(service.getFinished());
				System.out.println("fini");
				System.out.println("----->"+service.getRefusal());
				serviceTerminer.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
				
			}
			// Si validation != null && finished == null && rupture == null ==> En cours
			else if (service.getFinished() == null && service.getRefusal() == null && service.getRupture() == null && service.getValidation() != null) {
				System.out.println("en cour");
				serviceEnCour.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			}
			// si refus != null ==> annuler (Refuser)
			else if (service.getFinished() == null && service.getRefusal() != null && service.getRupture() == null && service.getValidation() != null) {
				System.out.println("refuser");
				System.out.println("=====>"+service.getRefusal());
				serviceRefuser.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			}
			// Si validation = null && refus null === en attente
			else if (service.getValidation() == null && service.getRefusal() == null && service.getRupture() == null && service.getValidation() == null) {
				System.out.println("en attente");
				serviceEnAttente.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			} else {
				System.out.println("Id du sans statut" + service.getId());
				System.out.println("Pas de statut sur cette prestation");
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			}
			System.out.println("=============================");
			service = null;
		}
		System.out.println(i);
		System.err.println("taille de la liste de service : " + servicelist.size());
		return servicelist;
	}

	private void serviceClean() {
		if (serviceEnAttente != null) {
			serviceEnAttente.clear();
		}
		if (serviceEnCour != null) {
			serviceEnCour.clear();
		}
		if (serviceTerminer != null) {
			serviceTerminer.clear();
		}
		if (serviceRefuser != null) {
			serviceRefuser.clear();
		}
	}

	public List<Herd> search(Field field) {
		return serviceIBusiness.search(field);
	}

	// TODO vin test
	public List<Herd> searchTest() {
		herds = serviceIBusiness.search(fieldIBusiness.extraireTerrainParId(15));
		return herds;
	}
	// TODO vin test
	public List<Float> distance() {
		dists = serviceIBusiness.distanceBU(fieldIBusiness.extraireTerrainParId(15));
		return dists;
	}

	public List<Service> getAllByIdAccountHerd(int idAccount) {
		return serviceIBusiness.getAllByIdAccountHerd(idAccount);
	}

	public List<Herd> getHerds() {
		return herds;
	}

	public void setHerds(List<Herd> herds) {
		this.herds = herds;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Herd getHerd() {
		return herd;
	}

	public void setHerd(Herd herd) {
		this.herd = herd;
	}

	public List<Float> getDists() {
		return dists;
	}

	public void setDists(List<Float> dists) {
		this.dists = dists;
	}

	public List<Service> getServiceEnAttente() {
		return serviceEnAttente;
	}

	public void setServiceEnAttente(List<Service> serviceEnAttente) {
		this.serviceEnAttente = serviceEnAttente;
	}

	public List<Service> getServiceEnCour() {
		return serviceEnCour;
	}

	public void setServiceEnCour(List<Service> serviceEnCour) {
		this.serviceEnCour = serviceEnCour;
	}

	public List<Service> getServiceTerminer() {
		return serviceTerminer;
	}

	public void setServiceTerminer(List<Service> serviceTerminer) {
		this.serviceTerminer = serviceTerminer;
	}

	public List<Service> getServiceRefuser() {
		return serviceRefuser;
	}

	public void setServiceRefuser(List<Service> serviceRefuser) {
		this.serviceRefuser = serviceRefuser;
	}

	public Service getServiceSelect() {
		return serviceSelect;
	}

	public void setServiceSelect(Service serviceSelect) {
		this.serviceSelect = serviceSelect;
	}

	public List<Service> getServicelist() {
		return servicelist;
	}

	public void setServicelist(List<Service> servicelist) {
		this.servicelist = servicelist;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public List<Incident> getIncidentsList() {
		return incidentsList;
	}

	public void setIncidentsList(List<Incident> incidentsList) {
		this.incidentsList = incidentsList;
	}
	public List<String> getDatums() {
		return datums;
	}
	public void setDatums(List<String> datums) {
		this.datums = datums;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}


}
