package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Incident;
import fr.eql.ai109.apptontapat.idao.IncidentIDao;


@Remote(IncidentIDao.class)
@Stateless
public class IncidentDao extends GenericDao<Incident> implements IncidentIDao{
	
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	

	@Override
	public Incident getIncidentById(int id) {
		Incident incident = null;
		List<Incident> incidents = null;
		Query query = em.createQuery("SELECT u FROM Incident u WHERE u.id=:idParam");
		query.setParameter("idParam", id);
		incidents = (List<Incident>) query.getResultList();
		if (incidents.size() > 0) {
			incident = incidents.get(0);
		}
		return incident;
	}

	@Override
	public Incident getIncidentByIdService(int id) {
		Incident incident = null;
		List<Incident> incidents = null;
		Query query = em.createQuery("SELECT u FROM Incident u WHERE u.service.id=:idParam");
		query.setParameter("idParam", id);
		incidents = (List<Incident>) query.getResultList();
		if (incidents.size() > 0) {
			incident = incidents.get(0);
		}
		return incident;
	}

	@Override
	public List<Incident> getAllByIdService(int id) {
		List<Incident> incidents = null;
		Query query = em.createQuery("SELECT u FROM Incident u WHERE u.service.id=:idParam");
		query.setParameter("idParam", id);
		incidents = (List<Incident>) query.getResultList();
		return incidents;
	}

}
