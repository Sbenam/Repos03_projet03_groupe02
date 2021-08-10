package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.idao.SlopeIDao;

@Remote(SlopeIDao.class)
@Stateless
public class SlopeDao extends GenericDao<Slope> implements SlopeIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Slope> getAllSlope() {
		List<Slope> slopes = null;
		Query query = em.createQuery("SELECT u FROM Slope u ");
		slopes = (List<Slope>) query.getResultList();
		return slopes;
	}

	@Override
	public List<String> getAllSlopeLabel() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Slope u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
