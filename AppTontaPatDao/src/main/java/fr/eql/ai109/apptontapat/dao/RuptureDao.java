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

}
