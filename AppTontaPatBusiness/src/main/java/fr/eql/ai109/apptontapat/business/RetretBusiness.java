package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Retret;
import fr.eql.ai109.apptontapat.ibusiness.RetretIBusiness;
import fr.eql.ai109.apptontapat.idao.RetretIDao;


@Remote(RetretIBusiness.class)
@Stateless
public class RetretBusiness implements RetretIBusiness{

	@EJB
	private RetretIDao retretIDao;
	
	@Override
	public List<Retret> extraireToutLesRetret() {
		return retretIDao.getAllRetret();
	}

}
