package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Clocking;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.idao.ClockingIDao;

@Remote(ClockingIDao.class)
@Stateless
public class ClockingDao extends GenericDao<Clocking> implements ClockingIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Clocking> getClockingByIdService(int id) {
		List<Clocking> clockings = null;
		Query query = em.createQuery("SELECT u FROM Clocking u WHERE u.service.id=:idParam");
		query.setParameter("idParam", id);
		clockings = (List<Clocking>) query.getResultList();
		return clockings;
	}

}
