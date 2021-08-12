package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Refusal;
import fr.eql.ai109.apptontapat.ibusiness.RefusalIBusiness;
import fr.eql.ai109.apptontapat.idao.RefusalIDao;

@Remote(RefusalIBusiness.class)
@Stateless
public class RefusalBusiness implements RefusalIBusiness{

	@EJB
	private RefusalIDao refusalIDao;
	
	@Override
	public List<Refusal> extraireToutesLesRefusal() {
		return refusalIDao.getAllRefusal();
	}

	@Override
	public List<String> extraireToutesLesRefusalLabels() {
		return refusalIDao.getAllRefusalLabels();
	}

}
