package fr.eql.ai109.apptontapat.dao;


import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;

@Remote(ServiceIDao.class)
@Stateless
public class ServiceDao extends GenericDao<Service> implements ServiceIDao {

//	@Override
//	public List<ZipCode> search(Field field) {
//		// TODO vin
//		List<ZipCode> zc = 	search(field.getZipcode().getLatitude(), field.getZipcode().getLongitude());
//		
//		return ;
//	}

	@Override
	public List<Herd> search(Field field) {
		// TODO vin
		List<Herd> herds = 	search(field.getZipcode().getLatitude(), field.getZipcode().getLongitude());
		Query query = em.createQuery(" SELECT h "
		+ "FROM Field f JOIN ZipCode zf ON f.zipcode = zf.id, "
		+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode "
		+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < (h.area + 50) "
		+ "AND h.id=:idParam ");
		query.setParameter("idParam", field.getId());
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
