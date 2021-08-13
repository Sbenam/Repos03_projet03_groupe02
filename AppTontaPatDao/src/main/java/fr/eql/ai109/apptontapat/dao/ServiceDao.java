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

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Herd> search(Field field) {
		// TODO vin
		List<Herd> herds = 	null ;
		
		Query query = em.createQuery(" SELECT h "
			+ "FROM Field f INNER JOIN ZipCode zf ON f.zipcode = zf.id, "
			+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode "
			+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < h.area "
			+ "AND f.id=:idParam "
			+ "AND f.id=:idParam ");
		query.setParameter("idParam", field.getId());
		
//		Query query = em.createQuery(" SELECT h "
//				+ "FROM Herd h "
//				+ "WHERE 100 * SQRT(POW(h.zipcode.longitude - (:longitudeParam), 2) + POW(h.zipcode.latitude - (:latitudeParam), 2)) < (h.area + 50) ");
//		query.setParameter("longitudeParam", field.getZipcode().getLongitude());
//		query.setParameter("latitudeParam", field.getZipcode().getLatitude());

		herds = (List<Herd>)query.getResultList();
		return herds;
}

	// TODO 
	@Override
	public List<Float> distances(Field field) {
		List<Float> dstcs = null;
		
		Query query = em.createQuery(" SELECT 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) "
				+ "FROM Field f INNER JOIN ZipCode zf ON f.zipcode = zf.id, "
				+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode "
				+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < h.area "
				+ "AND f.id=:idParam ");
		query.setParameter("idParam", field.getId());

		
//		Query query = em.createQuery(" SELECT 100 * SQRT(POW(h.zipcode.longitude - (:longitudeParam), 2) + POW(h.zipcode.latitude - (:latitudeParam), 2)) "
//				+ "FROM Herd h "
//				+ "WHERE 100 * SQRT(POW(h.zipcode.longitude - (:longitudeParam), 2) + POW(h.zipcode.latitude - (:latitudeParam), 2)) < h.area ");
//		query.setParameter("latitudeParam", field.getZipcode().getLatitude());
//		query.setParameter("longitudeParam", field.getZipcode().getLongitude());
		
		dstcs = query.getResultList();
		System.out.println("\r<<<<<<<<<<<<<<<<<<<<<<nb de distance : "+dstcs.size());
		return dstcs;
	}

	public List<Service> getAllByIdHerd(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.herd.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		return services;
	}

	public List<Service> getAllByIdAccount(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT s FROM Service s WHERE s.account.id=:idParam");
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
