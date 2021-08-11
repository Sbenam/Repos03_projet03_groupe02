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
		Query query = em.createQuery("SELECT u.label FROM ZipCode u");
		cityNames = query.getResultList();
		return cityNames;
	}

	@Override
	public String getCityByCode(String code) {
		List<String> citiesName = null;
		String cityName = null;
		Query query = em.createQuery("SELECT u.label FROM ZipCode u WHERE u.code=:codeParam");
		query.setParameter("codeParam",code);
		citiesName= query.getResultList();
		if (citiesName.size() > 0) {
			cityName =citiesName.get(0);
		}
		return cityName;
	}

}
