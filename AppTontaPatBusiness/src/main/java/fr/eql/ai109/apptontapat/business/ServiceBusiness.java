package fr.eql.ai109.apptontapat.business;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.entity.Rupture;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;
import fr.eql.ai109.apptontapat.entity.Service;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness {

	@EJB
	private ServiceIDao serviceIDao;
	

	@Override
	public List<Herd> search(Field field) {		
		return serviceIDao.search(field);
	}


	@Override
	public List<Float> distanceBU(Field field) {
		return serviceIDao.distances(field);
	}
		
	@Override
	public List<Service> extraireToutesLesPrestations() {
		return serviceIDao.getAll();
	}

	@Override
	public List<Service> extraireToutesLesPrestationsParIdTroupeau(int id) {
		return serviceIDao.getAllByIdHerd(id);
	}

	@Override
	public List<Service> extraireToutesLesPrestationsParIdTerrain(int id) {
		return serviceIDao.getAllByIdField(id);
	}

	@Override
	public Service ajoutPrestation(Service service) {
		return serviceIDao.add(service);
	}

	@Override
	public Service annoterUnePrestation(Integer id, Integer rateNote, Date rateDate, String rateComment) {
		Service service = serviceIDao.annotedService(id, rateNote, rateDate, rateComment);
		serviceIDao.update(service);
		return service;
	}

	@Override
	public List<Service> getAllByIdAccountField(int id) {
		return serviceIDao.getAllByIdAccountField(id);
	}

	@Override
	public List<Service> getAllByIdAccountHerd(int id) {
		return serviceIDao.getAllByIdAccountHerd(id);
	}


	@Override
	public Service cloturerUnePrestation(Date date, int id) {
		return serviceIDao.closeService(date, id);
	}


	@Override
	public Service cloturerUnePrestation(Date date, Service service) {
		return serviceIDao.closeService(date, service);
	}


	@Override
	public Service rompreUnePrestation(Service service, Rupture rupture) {
		return serviceIDao.ruptureService(service, rupture);
	}

	@Override
	public Service refusalService(Service service, Refusal refusal) {
		service.setRefusal(refusal);
		return service;
	}

	@Override
	public Service validationService(Service service, Date date) {
		service.setValidation(date);
		return service;
	}


	@Override
	public Service startService(Service service, Date date) {
		service.setPayment(date);
		return service;
	}


	@Override
	public Service reserveService(Service service, int nbService, Date booking, Herd herd, Date starting, Date ending,
			int cost) {
		service.setBooking(booking);
		service.setCost(cost);
		service.setEnding(ending);
		service.setHerd(herd);
		service.setNbService(nbService);
		service.setStarting(starting);
		return service;
	}


	@Override
	public int extraireNombrePrestationAvecUneNote(int note) {
		return serviceIDao.getNbrPrestationWithNote(note);
	}


	@Override
	public int numberServiceInProgress() {
		List<Service> services = serviceIDao.getAll();
		int nb=0;
		for (Service service : services) {
			if((service.getValidation()!=null)&&(service.getFinished()==null)) {
				nb++;
			}
		}
		return nb;
	}


	@Override
	public int numberServicerefusal() {
		List<Service> services = serviceIDao.getAll();
		int nb=0;
		for (Service service : services) {
			if(service.getRefusal()!=null) {
				nb++;
			}
		}
		return nb;
	}


	@Override
	public int numberServiceRupture() {
		List<Service> services = serviceIDao.getAll();
		int nb=0;
		for (Service service : services) {
			if(service.getRupture()!=null) {
				nb++;
			}
		}
		return nb;
	}


	@Override
	public int numberServiceFinished() {
		List<Service> services = serviceIDao.getAll();
		int nb=0;
		for (Service service : services) {
			if(service.getFinished()!=null) {
				nb++;
			}
		}
		return nb;
	}


	@Override
	public Service mettreAJourUnePrestation(Service service) {
		return serviceIDao.update(service);
	}
}
