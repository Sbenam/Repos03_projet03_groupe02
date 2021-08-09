package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.idao.SpecieIDao;


@Remote(SpecieIDao.class)
@Stateless
public class SpecieDao extends GenericDao<Specie> implements SpecieIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	
	@Override
	public List<Specie> getAllSpecie() {
		List<Specie> species = null;
		Query query = em.createQuery("SELECT u FROM Specie u ");
		species = (List<Specie>) query.getResultList();
		return species;
	}

}
