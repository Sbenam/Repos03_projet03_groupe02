package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness {

	@EJB
	private ServiceIDao serviceIDao;
	
//	@Override
//	public List<ZipCode> search(Field field) {		
//		return serviceIDao.search(field.getZipcode().getLatitude(), field.getZipcode().getLatitude());
//	}

	@Override
	public List<Herd> search(Field field) {		
		return search(field.getZipcode().getLatitude(), field.getZipcode().getLatitude());
	}

	@Override
	public List<Herd> search(Double latitude, Double longitude) {
		return serviceIDao.search(latitude, longitude);
	}

	@Override
	public List<Float> distanceBU(Field field) {
		return serviceIDao.distances(field);
	}
		
}
