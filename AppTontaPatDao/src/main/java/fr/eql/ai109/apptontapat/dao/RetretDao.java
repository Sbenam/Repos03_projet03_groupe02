package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.idao.RetretIDao;


@Remote(RetretIDao.class)
@Stateless
public class RetretDao extends GenericDao<Retret> implements RetretIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager String;

	@Override
	public List<Retret> getAllRetret() {
		List<Retret> retrets = null;
		Query query = em.createQuery("SELECT u FROM Retret u ");
		retrets = (List<Retret>) query.getResultList();
		return retrets;
	}

	@Override
	public List<String> getAllRetretLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Retret u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

	@Override
	public Retret getIdRetretByLabel(java.lang.String label) {
		List<Retret> ids = null;
		Retret id = null;
		Query query = em.createQuery("SELECT u FROM Retret u WHERE u.label =:labelParam");
		query.setParameter("labelParam", label);
		ids = (List<Retret>) query.getResultList();
		if (ids.size() > 0) {
			id = ids.get(0);
		}
		return id;
	}

}
