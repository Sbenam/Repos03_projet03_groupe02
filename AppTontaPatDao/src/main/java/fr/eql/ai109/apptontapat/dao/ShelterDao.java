package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Shelter;
import fr.eql.ai109.apptontapat.idao.ShelterIDao;

@Remote(ShelterIDao.class)
@Stateless
public class ShelterDao extends GenericDao<Shelter> implements ShelterIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	
	@Override
	public List<Shelter> getAllShelter() {
		List<Shelter> shelters = null;
		Query query = em.createQuery("SELECT u FROM Shelter u ");
		shelters = (List<Shelter>) query.getResultList();
		return shelters;
	}

}
