package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.idao.CompositionIDao;

@Remote(CompositionIDao.class)
@Stateless
public class CompositionDao extends GenericDao<Composition> implements CompositionIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	@Override
	public List<Composition> getAllComposition() {
		List<Composition> compositions = null;
		Query query = em.createQuery("SELECT u FROM Composition u ");
		compositions = (List<Composition>) query.getResultList();
		return compositions;
	}

	@Override
	public List<String> getAllCompositionLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Composition u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
