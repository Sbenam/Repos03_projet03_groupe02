package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Desactivation;
import fr.eql.ai109.apptontapat.ibusiness.DesactivationIBusiness;
import fr.eql.ai109.apptontapat.idao.DesactivationIDao;



@Remote(DesactivationIBusiness.class)
@Stateless
public class DesactivationBusiness implements DesactivationIBusiness{

	@EJB
	private DesactivationIDao desactivationIDao;
	
	@Override
	public List<Desactivation> extraireToutesLesDesactivation() {
		return desactivationIDao.getAllDesactivation();
	}

}
