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

}
