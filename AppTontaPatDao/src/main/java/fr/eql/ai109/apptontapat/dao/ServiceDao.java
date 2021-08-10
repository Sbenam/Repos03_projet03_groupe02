package fr.eql.ai109.apptontapat.dao;


import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;

@Remote(ServiceIDao.class)
@Stateless
public class ServiceDao extends GenericDao<Service> implements ServiceIDao {

	@Override
	public List<Herd> search(Field field) {
		// TODO vin
		List<Herd> herds = 	search(field.getZipcode().getLatitude(), field.getZipcode().getLongitude());
		
		return herds;
	}

	@Override
	public List<Herd> search(Double latitude, Double longitude) {
		List<Herd> herds = null;
		
		Query query = em.createQuery(" SELECT h FROM Herd h WHERE SQRT(POW(h.zipcode.longitude - :longitudeParam, 2) + POW(h.zipcode.latitude - :latitudeParam, 2)) < 0.6 ");
		query.setParameter("longitudeParam", longitude);
		query.setParameter("latitudeParam", latitude);
		herds = query.getResultList();
		
		return herds;
	}


}
