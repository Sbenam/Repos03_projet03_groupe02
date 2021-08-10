package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Water;
import fr.eql.ai109.apptontapat.idao.WaterIDao;

@Remote(WaterIDao.class)
@Stateless
public class WaterDao extends GenericDao<Water> implements WaterIDao{


	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Water> getAllWater() {
		List<Water> waters = null;
		Query query = em.createQuery("SELECT u FROM Water u ");
		waters = (List<Water>) query.getResultList();
		return waters;
	}

	@Override
	public List<String> getAllWaterLabel() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Water u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
