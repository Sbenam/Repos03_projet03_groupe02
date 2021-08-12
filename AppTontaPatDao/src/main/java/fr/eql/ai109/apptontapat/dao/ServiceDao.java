package fr.eql.ai109.apptontapat.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Herd> search(Field field) {
		// TODO vin
		List<Herd> herds = 	null ; //search(field.getZipcode().getLatitude(), field.getZipcode().getLongitude());
		Query query = em.createQuery(" SELECT h "
		+ "FROM Field f INNER JOIN ZipCode zf ON f.zipcode = zf.id, "
		+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode "
		+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < h.area "
		+ "AND f.id=:idParam ");
				query.setParameter("idParam", field.getId());
		herds = query.getResultList();
		
		return search(field.getZipcode().getLatitude(), field.getZipcode().getLongitude()) ;
	}

	@Override
	public List<Herd> search(Double latitude, Double longitude) {
		List<Herd> herds = null;
		
		Query query = em.createQuery(" SELECT h "
				+ "FROM Herd h "
				+ "WHERE (100 * SQRT(POW((h.zipcode.longitude - :longitudeParam), 2) + POW((h.zipcode.latitude - :latitudeParam), 2))) < h.area ");
		query.setParameter("longitudeParam", longitude);
		query.setParameter("latitudeParam", latitude);
		herds = query.getResultList();
		System.out.println("\r<<<<<<<<<<<<<<<<<<<<<<"+herds.size());
		return herds;
	}

	@Override
	public List<Float> distances(Field field) {
		List<Float> dstcs = null;
		
		Query query = em.createQuery(" SELECT 100 * SQRT(POW(h.zipcode.longitude - (:longitudeParam), 2) + POW(h.zipcode.latitude - (:latitudeParam), 2)) "
				+ "FROM Herd h "
				+ "WHERE 100 * SQRT(POW(h.zipcode.longitude - (:longitudeParam), 2) + POW(h.zipcode.latitude - (:latitudeParam), 2)) < h.area ");
		query.setParameter("longitudeParam", field.getZipcode().getLongitude());
		query.setParameter("latitudeParam", field.getZipcode().getLatitude());
		dstcs = query.getResultList();
		System.out.println("\r<<<<<<<<<<<<<<<<<<<<<<"+dstcs.size());
		return dstcs;
	}

	public List<Service> getAllByIdHerd(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.herd.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		return services;
	}

	@Override
	public List<Service> getAllByIdField(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.field.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		return services;
	}

	@Override
	public Service annotedService(Integer id, Integer rateNote, Date rateDate, String rateComment) {
		List<Service> services = null;
		Service service = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		if (services.size() > 0) {
			service = services.get(0);
		}
		service.setRateDate(rateDate);
		service.setRateComment(rateComment);
		service.setRateNote(rateNote);
		return service;
	}
}
