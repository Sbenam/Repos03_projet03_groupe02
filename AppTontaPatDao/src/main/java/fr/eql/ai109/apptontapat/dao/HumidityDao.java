package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Humidity;
import fr.eql.ai109.apptontapat.idao.HumidityIDao;


@Remote(HumidityIDao.class)
@Stateless
public class HumidityDao extends GenericDao<Humidity> implements HumidityIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public List<Humidity> getAllHumidity() {
		List<Humidity> humidities = null;
		Query query = em.createQuery("SELECT u FROM Humidity u ");
		humidities = (List<Humidity>) query.getResultList();
		return humidities;
	}

}
