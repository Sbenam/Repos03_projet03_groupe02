package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Specie;
import fr.eql.ai109.apptontapat.ibusiness.SpecieIBusiness;
import fr.eql.ai109.apptontapat.idao.SpecieIDao;

@Remote(SpecieIBusiness.class)
@Stateless
public class SpecieBusiness implements SpecieIBusiness{

	@EJB
	private SpecieIDao specieIDao;
	
	@Override
	public List<Specie> extraireToutLesSpecies() {
		return specieIDao.getAllSpecie();
	}

}
