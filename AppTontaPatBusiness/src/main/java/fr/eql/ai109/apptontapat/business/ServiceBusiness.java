package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;


@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness{
	
	@EJB
	private ServiceIDao serviceIDao;

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

}
