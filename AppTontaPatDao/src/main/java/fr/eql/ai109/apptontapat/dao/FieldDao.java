package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.entity.Service;
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
		fields = (List<Field>) query.getResultList();
		if (fields.size() > 0) {
			field = fields.get(0);
		}
		return field;
	}


	@Override
	public Field getFieldByIdAccount(int id) {
		Field field = null;
		List<Field> fields = null;
		Query query = em.createQuery("SELECT u FROM Field u WHERE u.account.id=:idParam");
		query.setParameter("idParam", id);
		fields = (List<Field>) query.getResultList();
		if (fields.size() > 0) {
			field = fields.get(0);
		}
		return field;
	}


	@Override
	public Field removeFieldById(int id) {
		return null;
	}


	@Override
	public Field removeFieldByIdAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Field>  getAll() {
		List<Field> fields = null;
		Query query = em.createQuery("SELECT u FROM Field u ");
		fields = (List<Field>) query.getResultList();
		return fields;
	}


	@Override
	public List<Field>  getAllByIdAccount(int id) {
		List<Field> fields = null;
		Query query = em.createQuery("SELECT u FROM Field u WHERE u.account.id=:idParam");
		query.setParameter("idParam", id);
		fields = (List<Field>) query.getResultList();
		return fields;
	}


	@Override
	public Field retirerField(String label, Integer id) {
		List<Field> fields = null;
		Field field = null;
		Query query = em.createQuery("SELECT u FROM Field u WHERE u.id=:idParam");
		query.setParameter("idParam", id);
		fields = (List<Field>) query.getResultList();
		if (fields.size() > 0) {
			field = fields.get(0);
		}

		return field;		
	}

}
