package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.entity.Desactivation;
import fr.eql.ai109.apptontapat.idao.DesactivationIDao;


@Remote(DesactivationIDao.class)
@Stateless
public class DesactivationDao extends GenericDao<Desactivation> implements DesactivationIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Desactivation> getAllDesactivation() {
		List<Desactivation> desactivations = null;
		Query query = em.createQuery("SELECT u FROM Desactivation u ");
		desactivations = (List<Desactivation>) query.getResultList();
		return desactivations;
	}

}