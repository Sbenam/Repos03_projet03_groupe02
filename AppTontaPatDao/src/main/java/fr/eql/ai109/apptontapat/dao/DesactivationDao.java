package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.entity.Desactivation;
import fr.eql.ai109.apptontapat.entity.Retret;
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

	@Override
	public List<String> getAllDesactivationLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Desactivation u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

	@Override
	public Desactivation getIdDesactivationByLabel(String label) {
		List<Desactivation> desactivations = null;
		Desactivation desactivation = null;
		Query query = em.createQuery("SELECT u FROM Desactivation u WHERE u.label =:labelParam");
		query.setParameter("labelParam", label);
		desactivations = (List<Desactivation>) query.getResultList();
		if (desactivations.size() > 0) {
			desactivation = desactivations.get(0);
		}
		return desactivation;
	}

}
