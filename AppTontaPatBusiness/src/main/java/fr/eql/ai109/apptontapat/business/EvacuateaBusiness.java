package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.EvacuateA;
import fr.eql.ai109.apptontapat.ibusiness.EvacuateaIBusiness;
import fr.eql.ai109.apptontapat.idao.EvacuateaIDao;


@Remote(EvacuateaIBusiness.class)
@Stateless
public class EvacuateaBusiness implements EvacuateaIBusiness{

	@EJB
	private EvacuateaIDao evacuateaIDao;
	
	@Override
	public List<EvacuateA> extraireToutesLesEvacuateA() {
		return evacuateaIDao.getAllEvacuatea();
	}

}
