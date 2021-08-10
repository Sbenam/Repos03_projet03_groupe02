package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Vegetation;
import fr.eql.ai109.apptontapat.idao.VegetationIDao;


@Remote(VegetationIDao.class)
@Stateless
public class VegetationDao extends GenericDao<Vegetation> implements VegetationIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Vegetation> getAllVegetation() {
		List<Vegetation> vegetations = null;
		Query query = em.createQuery("SELECT u FROM Vegetation u ");
		vegetations = (List<Vegetation>) query.getResultList();
		return vegetations;
	}

}
