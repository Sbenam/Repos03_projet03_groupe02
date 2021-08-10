package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.GlassHeight;
import fr.eql.ai109.apptontapat.idao.GlassHeightIDao;

@Remote(GlassHeightIDao.class)
@Stateless
public class GlassHeightDao extends GenericDao<GlassHeight> implements GlassHeightIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	
	@Override
	public List<GlassHeight> getAllGlassHeight() {
		List<GlassHeight> glassHeights = null;
		Query query = em.createQuery("SELECT u FROM GlassHeight u ");
		glassHeights = (List<GlassHeight>) query.getResultList();
		return glassHeights;
	}


	@Override
	public List<String> getAllGlassHeightLabel() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM GlassHeight u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
