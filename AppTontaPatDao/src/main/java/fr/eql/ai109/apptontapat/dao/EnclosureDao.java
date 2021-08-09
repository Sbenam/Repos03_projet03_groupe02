package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Enclosure;
import fr.eql.ai109.apptontapat.idao.EnclosureIDao;

@Remote(EnclosureIDao.class)
@Stateless
public class EnclosureDao extends GenericDao<Enclosure> implements EnclosureIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	
	@Override
	public List<Enclosure> getAllEnclosure() {
		List<Enclosure> enclosures = null;
		Query query = em.createQuery("SELECT u FROM Enclosure u ");
		enclosures = (List<Enclosure>) query.getResultList();
		return enclosures;
	}

}
