package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Enclosure;
import fr.eql.ai109.apptontapat.ibusiness.EnclosureIbusiness;
import fr.eql.ai109.apptontapat.idao.EnclosureIDao;


@Remote(EnclosureIbusiness.class)
@Stateless
public class EnclosureBusiness implements EnclosureIbusiness{

	@EJB
	private EnclosureIDao enclosureIDao;
	
	@Override
	public List<Enclosure> extraireToutesLesEnclosures() {
		return enclosureIDao.getAllEnclosure();
	}

	@Override
	public List<String> extraireToutesLesEnclosuresLabels() {
		return enclosureIDao.getAllEnclosureLabel();
	}

}
