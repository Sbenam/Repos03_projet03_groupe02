package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.idao.RaceIDao;

@Remote(RaceIDao.class)
@Stateless
public class RaceDao extends GenericDao<Race> implements RaceIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Race> getAllRace() {
		List<Race> races = null;
		Query query = em.createQuery("SELECT u FROM Race u ");
		races = (List<Race>) query.getResultList();
		return races;
	}

}
