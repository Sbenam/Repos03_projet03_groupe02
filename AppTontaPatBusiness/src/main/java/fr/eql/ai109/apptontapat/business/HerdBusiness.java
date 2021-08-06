package fr.eql.ai109.apptontapat.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;
import fr.eql.ai109.apptontapat.idao.HerdIDao;


@Remote(HerdIbusiness.class)
@Stateless
public class HerdBusiness implements HerdIbusiness{

	@EJB
	private HerdIDao herdIDao;
	
	@Override
	public Herd extraireTroupeauParId(int id) {
		// TODO Auto-generated method stub
		return herdIDao.getHerdById(id);
	}

}
