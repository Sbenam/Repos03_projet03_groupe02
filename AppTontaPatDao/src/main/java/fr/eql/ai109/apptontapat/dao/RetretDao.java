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
	protected EntityManager em;

	@Override
	public List<Retret> getAllRetret() {
		List<Retret> retrets = null;
		Query query = em.createQuery("SELECT u FROM Retret u ");
		retrets = (List<Retret>) query.getResultList();
		return retrets;
	}

}
