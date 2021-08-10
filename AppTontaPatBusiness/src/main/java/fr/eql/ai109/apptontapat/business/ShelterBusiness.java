package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Shelter;
import fr.eql.ai109.apptontapat.ibusiness.ShelterIBusiness;
import fr.eql.ai109.apptontapat.idao.ShelterIDao;

@Remote(ShelterIBusiness.class)
@Stateless
public class ShelterBusiness implements ShelterIBusiness{

	@EJB
	private ShelterIDao shelterIDao;
	
	@Override
	public List<Shelter> extraireToutLesShelters() {
		return shelterIDao.getAllShelter();
	}

	@Override
	public List<String> extraireToutLesSheltersLabels() {
		return shelterIDao.getAllShelterLabel();
	}

}
