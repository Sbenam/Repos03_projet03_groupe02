package fr.eql.ai109.apptontapat.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.idao.GenericIDao;

// TODO VIN retirer les commentaires
public abstract class GenericDao<T> implements GenericIDao<T> {

	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	public T add(T t) {
		em.persist(t);
		return t;
	}

	public void delete(T t) {
		em.remove(t);
	}

	public T update(T t) {
		em.merge(t);
		return t;
	}
	
	public T getById(int i) {
		T t = null;
		System.out.println("rllfkf"+em);
		try {

			String className = ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0].getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);

			t= (T)em.find(clazz, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(em);
		return t;
	}

	public List<T> getAll() {
		List<T> objects = null;
		try {
			String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			Query query = em.createQuery("FROM " + clazz.getName());
			objects = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return objects;
	}
}
