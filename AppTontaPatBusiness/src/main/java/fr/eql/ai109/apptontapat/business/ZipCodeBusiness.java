package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.ZipCodeIBusiness;
import fr.eql.ai109.apptontapat.idao.ZipCodeIDao;

@Remote(ZipCodeIBusiness.class)
@Stateless
public class ZipCodeBusiness implements ZipCodeIBusiness{

	@EJB
	private ZipCodeIDao zipCodeIDao;

	@Override
	public List<ZipCode> getAllBu() {
		return zipCodeIDao.getAll();
	}
	
	
	
}
