package fr.eql.ai109.apptontapat.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.entity.Rupture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.idao.ServiceIDao;

@Remote(ServiceIDao.class)
@Stateless
public class ServiceDao extends GenericDao<Service> implements ServiceIDao {

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Herd> search(Field field) {
		List<Herd> herds = 	null ;
		Query query = em.createQuery(" SELECT DISTINCT h "
			+ "FROM Field f JOIN ZipCode zf ON f.zipcode.id = zf.id, "
			+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode, "
			+ "Service s LEFT JOIN Herd hs  on s.herd = hs.id "
			+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < (h.area + 100) "
			+ "AND h.starting < f.starting "
			+ "AND f.ending < h.ending "
			+ "AND h.seize <= (f.surface + 8) "
			+ "AND (f.surface * 2.7) / datediff(f.ending, f.starting) <= h.seize "
			+ "AND s.validation is null "
			+ "AND f.id=:idParam ");
		query.setParameter("idParam", field.getId());	
		herds = (List<Herd>)query.getResultList();
		return herds;
	}

	// TODO vin test
	@Override
	public List<Float> distances(Field field) {
		List<Float> dstcs = null;
		Query query = em.createQuery(" SELECT 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) "
				+ "FROM Field f INNER JOIN ZipCode zf ON f.zipcode = zf.id, "
				+ "ZipCode zh JOIN Herd h ON zh.id = h.zipcode "
				+ "WHERE 100 * SQRT(POW(zf.latitude - zh.latitude, 2) + POW(zf.longitude - zh.longitude, 2)) < h.area "
				+ "AND f.id=:idParam ");
		query.setParameter("idParam", field.getId());	
		dstcs = query.getResultList();
		return dstcs;
	}

	public List<Service> getAllByIdHerd(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.herd.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		return services;
	}

	public List<Service> getAllByIdAccountField(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT DISTINCT s FROM Service s WHERE s.field.account.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		return services;
	}

	public List<Service> getAllByIdAccountHerd(int id) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT s FROM Service s WHERE s.herd.account.id=:idParam");
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

	@Override
	public Service closeService(Date date, Service service) {
		service.setEnding(date);
		return service;
		
	}

	@Override
	public Service closeService(Date date, int id) {
		List<Service> services = null;
		Service service = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.id=:idParam");
		query.setParameter("idParam", id);
		services = (List<Service>) query.getResultList();
		if (services.size() > 0) {
			service = services.get(0);
		}
		service.setEnding(date);
		return service;
	}

	@Override
	public Service ruptureService(Service service, Rupture rupture) {
		service.setRupture(rupture);
		return service;
	}

	@Override
	public List<Service> getAllByAccountId(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbrPrestationWithNote(int note) {
		List<Service> services = null;
		Query query = em.createQuery("SELECT u FROM Service u WHERE u.rateNote=:idParam");
		query.setParameter("idParam", note);
		services = (List<Service>) query.getResultList();
		return services.size();
	}
}
