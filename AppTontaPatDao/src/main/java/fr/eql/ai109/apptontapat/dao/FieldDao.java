package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.idao.FieldIDao;

@Remote(FieldIDao.class)
@Stateless
public class FieldDao extends GenericDao<Field> implements FieldIDao{

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;
	
	
	@Override
	public Field getFieldById(int id) {
		Field field = null;
		List<Field> fields = null;
		Query query = em.createQuery("SELECT u FROM Field u WHERE u.id=:idParam");
		query.setParameter("idParam", id);
		if (fields.size() > 0) {
			field = fields.get(0);
		}
		return field;
	}

}
