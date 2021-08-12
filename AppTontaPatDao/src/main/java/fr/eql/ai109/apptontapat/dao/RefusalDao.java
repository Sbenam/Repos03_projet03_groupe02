package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.idao.RefusalIDao;


@Remote(RefusalIDao.class)
@Stateless
public class RefusalDao extends GenericDao<Refusal> implements RefusalIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Refusal> getAllRefusal() {
		List<Refusal> refusals = null;
		Query query = em.createQuery("SELECT u FROM Refusal u ");
		refusals = (List<Refusal>) query.getResultList();
		return refusals;
	}

	@Override
	public List<String> getAllRefusalLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Refusal u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
