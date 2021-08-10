package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.idao.ZipCodeIDao;

@Remote(ZipCodeIDao.class)
@Stateless
public class ZipCodeDao extends GenericDao<ZipCode> implements ZipCodeIDao{

	@Override
	public List<String> getAllCity() {
		List<String> cityNames = null;
		Query query = em.createQuery("SELECT z.label FROM ZipCode z");
		cityNames = query.getResultList();
		return cityNames;
	}

	@Override
	public List<String> getCityByCode(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
