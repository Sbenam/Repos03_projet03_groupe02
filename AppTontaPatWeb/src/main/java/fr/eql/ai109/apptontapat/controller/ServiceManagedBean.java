package fr.eql.ai109.apptontapat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
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


	@EJB
	private ServiceIBusiness serviceIBusiness;

	@EJB
	private FieldIBusiness fieldIBusiness;


	public void getServiceDetail(PageManageBean p,Service s) {
		serviceSelect = s;
		p.setPage("service_detail");
	}

	public List<Service> getAllByIdAccount(int id) {
		if (servicelist != null) {
			serviceClean();
		}
		servicelist = serviceIBusiness.getAllByIdAccountField(id);

		// repartition des listes
		for (Service service : servicelist) {

			// si finished != null  et refus == null ==> Fini
			if (service.getFinished() != null && service.getRefusal() == null) {
				System.out.println(service.getFinished());
				System.out.println("fini");
				serviceTerminer.add(service);
			}
			// Si validation != null && finished == null && rupture == null ==> En cours
			else if (service.getValidation() != null && service.getFinished() == null && service.getRupture() == null) {
				System.out.println("en cour");
				serviceEnCour.add(service);
			}
			// si refus != null ==> annuler (Refuser)
			else if (service.getValidation() != null && service.getRefusal() != null) {
				System.out.println("refuser");
				serviceRefuser.add(service);
			}
			// Si validation = null && refus null === en attente
			else if (service.getValidation() != null & service.getRefusal() == null) {
				System.out.println("en attente");
				serviceEnAttente.add(service);
			} else {
				System.out.println("Id du sans statut" + service.getId());
				System.out.println("Pas de statut sur cette prestation");
			}

		}

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

}
