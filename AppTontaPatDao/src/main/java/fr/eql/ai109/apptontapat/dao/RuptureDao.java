package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Rupture;
import fr.eql.ai109.apptontapat.idao.RuptureIDao;


@Remote(RuptureIDao.class)
@Stateless
public class RuptureDao extends GenericDao<Rupture> implements RuptureIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Rupture> getAllComposition() {
		List<Rupture> ruptures = null;
		Query query = em.createQuery("SELECT u FROM Rupture u ");
		ruptures = (List<Rupture>) query.getResultList();
		return ruptures;
	}

	@Override
	public List<String> getAllCompositionLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Rupture u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

	@Override
	public Rupture getIdRuptureByLabel(String label) {
		List<Rupture> ids = null;
		Rupture id = null;
		Query query = em.createQuery("SELECT u FROM Rupture u WHERE u.label =:labelParam");
		query.setParameter("labelParam", label);
		ids = (List<Rupture>) query.getResultList();
		if (ids.size() > 0) {
			id = ids.get(0);
		}
		return id;
	}

}
