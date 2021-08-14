package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.idao.TakeoutIDao;


@Remote(TakeoutIDao.class)
@Stateless
public class TakeoutDao extends GenericDao<TakeOut> implements TakeoutIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<TakeOut> getAllTakeOut() {
		List<TakeOut> takeouts = null;
		Query query = em.createQuery("SELECT u FROM TakeOut u ");
		takeouts = (List<TakeOut>) query.getResultList();
		return takeouts;
	}

	@Override
	public List<String> getAllTakeOutLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM TakeOut u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

	@Override
	public TakeOut getIdTakeoutByLabel(String label) {
		List<TakeOut> ids = null;
		TakeOut id = null;
		Query query = em.createQuery("SELECT u FROM TakeOut u WHERE u.label =:labelParam");
		query.setParameter("labelParam", label);
		ids = (List<TakeOut>) query.getResultList();
		if (ids.size() > 0) {
			id = ids.get(0);
		}
		return id;
	}

}
