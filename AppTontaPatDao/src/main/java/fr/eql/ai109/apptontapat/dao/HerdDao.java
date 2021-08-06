package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.idao.HerdIDao;

@Remote(HerdIDao.class)
@Stateless
public class HerdDao extends GenericDao<Herd> implements HerdIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

	@Override
	public void addHerd(Herd herd) {
		Query query = em.createQuery("INSERT INTO Herd u WHERE u.login=:one AND u.password=:two ");
	}

	@Override
	public Herd getHerdById(int id) {
		Herd herd = null;
		List<Herd> herds = null;
		Query query = em.createQuery("SELECT u FROM Herd u WHERE u.id=:loginParam");
		query.setParameter("loginParam", id);
		herds = (List<Herd>) query.getResultList();
		if (herds.size() > 0) {
			herd = herds.get(0);
		}
		return herd;
	}

}
