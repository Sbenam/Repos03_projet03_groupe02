package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Incident;
import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.ibusiness.DatumIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.IncidentIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.RefusalIBusiness;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.web.PageManageBean;
import fr.eql.ai109.apptontapat.web.PrestationManageBean;

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
	private List<Incident> incidentsList;
	private List<String> datums = new ArrayList<String>();
	private Integer rating;
	private int serviceCost;
	private String classEleveur;
	private String classClient;
	private String selectRefusal;

	public String getClassClient() {
		return classClient;
	}

	public void setClassClient(String classClient) {
		this.classClient = classClient;
	}

	@EJB
	private ServiceIBusiness serviceIBusiness;

	@EJB
	private FieldIBusiness fieldIBusiness;

	@EJB
	private IncidentIBusiness incidentIBusiness;
	@EJB
	private DatumIBusiness datumIBusiness;
	@EJB
	private RefusalIBusiness RefusalIBusiness;

	public List<Incident> getAllIncident() {
		incidentsList = incidentIBusiness.extraireToutLesIncident();
		return incidentsList;
	}

	public List<String> getAllDatum() {
		datums = datumIBusiness.extraireToutesLesDatumLabels();
		return datums;
	}

	public void addService(Herd herd, Field field, PrestationManageBean p, PageManageBean bean) {
		Service service = new Service();
		Random r = new Random();
		service.setNbService(r.nextInt());

		// nombre de jour * nombre de mouton * prix (serciceCost)
		LocalDateTime fieldstartDateTime = LocalDateTime.ofInstant(field.getStarting().toInstant(),
				ZoneId.systemDefault());
		LocalDateTime fieldEndDateTime = LocalDateTime.ofInstant(field.getEnding().toInstant(), ZoneId.systemDefault());

		long nmbJour = Duration.between(fieldstartDateTime, fieldEndDateTime).toDays();
		service.setCost((int) (serviceCost * nmbJour * herd.getSeize()));
		service.setStarting(field.getStarting());
		service.setBooking(new Date());
		service.setEnding(field.getEnding());
		service.setHerd(herd);
		service.setField(field);

		serviceIBusiness.ajoutPrestation(service);
		bean.setPage("ConnectedPage");
		getServiceDetail(p, service, "service_detail_waiting", false);

	}

	public void validateService(PrestationManageBean p) {
		serviceIBusiness.validationService(serviceSelect, new Date());
		p.setServiceView("enCours");
	}

	public void refusalView(PrestationManageBean p) {
		p.setServiceViewPopup("refusal_service_choice");
	}

	public void refusalService(PrestationManageBean p) {
		// refus a modifier pour prendre le refus choisis
		System.out.println("test de la valeur: " + selectRefusal);
		System.out.println("Service selected id: " + serviceSelect.getId());
		serviceSelect.setRefusal(getAllRefusal().get(Integer.parseInt(selectRefusal)));
		//manque update
		p.setServiceViewPopup("blank");
		p.setServiceView("annuler");
	}

	public void getServiceDetail(PrestationManageBean p, Service s, String page, Boolean eleveur) {
		// si eleveur true string class eleveur display && string class client hiden
		if (eleveur) {
			classEleveur = "displayblock";
			classClient = "displaynone";
		} else {
			classEleveur = "displaynone";
			classClient = "displayblock";
		}

		serviceSelect = s;
		p.setServiceView(page);
	}

	public List<Service> getAllByIdAccount(int id) {
		if (servicelist != null) {
			serviceClean();
		}
		servicelist = serviceIBusiness.getAllByIdAccountField(id);
		int i = 0;
		// repartition des listes
		for (Service service : servicelist) {

			// si finished != null et refus == null ==> Fini
			if (service.getFinished() != null && service.getRefusal() == null && service.getRupture() == null
					&& service.getValidation() != null) {
				System.out.println(service.getFinished());
				System.out.println("fini");
				System.out.println("----->" + service.getRefusal());
				serviceTerminer.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());

			}
			// Si validation != null && finished == null && rupture == null ==> En cours
			else if (service.getFinished() == null && service.getRefusal() == null && service.getRupture() == null
					&& service.getValidation() != null) {
				System.out.println("en cour");
				serviceEnCour.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			}
			// si refus != null ==> annuler (Refuser)
			else if (service.getFinished() == null && service.getRefusal() != null && service.getRupture() == null
					&& service.getValidation() != null) {
				System.out.println("refuser");
				System.out.println("=====>" + service.getRefusal());
				serviceRefuser.add(service);
				System.out.println(i++);
				System.out.println(service.getRefusal() == null);
				System.out.println("ID : " + service.getId());
				System.out.println("nb SERVICE : " + service.getNbService());
			}
			// Si validation = null && refus null === en attente
			else if (service.getValidation() == null && service.getRefusal() == null && service.getRupture() == null
					&& service.getValidation() == null) {
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

	public List<Refusal> getAllRefusal() {
		return RefusalIBusiness.extraireToutesLesRefusal();
	}

	public List<Herd> search(Field field) {
		return serviceIBusiness.search(field);
	}

	public List<Herd> searchTest() {
		herds = serviceIBusiness.search(fieldIBusiness.extraireTerrainParId(15));
		return herds;
	}

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

	public int getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getClassEleveur() {
		return classEleveur;
	}

	public void setClassEleveur(String classEleveur) {
		this.classEleveur = classEleveur;
	}

	public String getSelectRefusal() {
		return selectRefusal;
	}

	public void setSelectRefusal(String selectRefusal) {
		this.selectRefusal = selectRefusal;
	}

}
