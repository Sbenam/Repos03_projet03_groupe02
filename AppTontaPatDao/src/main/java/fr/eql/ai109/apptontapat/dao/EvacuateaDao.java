package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.idao.EvacuateaIDao;

@Remote(EvacuateaIDao.class)
@Stateless
public class EvacuateaDao extends GenericDao<EvacuateA> implements EvacuateaIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<EvacuateA> getAllEvacuatea() {
		List<EvacuateA> evacuateas = null;
		Query query = em.createQuery("SELECT u FROM EvacuateA u ");
		evacuateas = (List<EvacuateA>) query.getResultList();
		return evacuateas;
	}

	@Override
	public List<String> getAllEvacuateaLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM EvacuateA u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

	@Override
	public EvacuateA getIdEvacuateaByLabel(String label) {
		List<EvacuateA> ids = null;
		EvacuateA id = null;
		Query query = em.createQuery("SELECT u FROM EvacuateA u WHERE u.label =:labelParam");
		query.setParameter("labelParam", label);
		ids = (List<EvacuateA>) query.getResultList();
		if (ids.size() > 0) {
			id = ids.get(0);
		}
		return id;
	}

}
