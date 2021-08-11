package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eql.ai109.apptontapat.entity.Datum;
import fr.eql.ai109.apptontapat.idao.DatumIDao;


@Remote(DatumIDao.class)
@Stateless
public class DatumDao extends GenericDao<Datum> implements DatumIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Datum> getAllDatum() {
		List<Datum> datums = null;
		Query query = em.createQuery("SELECT u FROM Datum u ");
		datums = (List<Datum>) query.getResultList();
		return datums;
	}

	@Override
	public List<String> getAllDatumLabels() {
		List<String> labels = null;
		Query query = em.createQuery("SELECT u.label FROM Datum u ");
		labels = (List<String>) query.getResultList();
		return labels;
	}

}
