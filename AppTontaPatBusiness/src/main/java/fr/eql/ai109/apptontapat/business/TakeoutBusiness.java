package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.TakeOut;
import fr.eql.ai109.apptontapat.ibusiness.TakeoutIBusiness;
import fr.eql.ai109.apptontapat.idao.TakeoutIDao;


@Remote(TakeoutIBusiness.class)
@Stateless
public class TakeoutBusiness implements TakeoutIBusiness{

	@EJB
	private TakeoutIDao takeoutIDao;
	
	@Override
	public List<TakeOut> extraireToutesLesTakeout() {
		return takeoutIDao.getAllTakeOut();
	}

	@Override
	public List<String> extraireToutesLesTakeoutLabels() {
		return takeoutIDao.getAllTakeOutLabels();
	}

	@Override
	public TakeOut extraireTakeoutAPartirDeLabel(String label) {
		return takeoutIDao.getIdTakeoutByLabel(label);
	}

}
