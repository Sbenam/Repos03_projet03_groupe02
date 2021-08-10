package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Slope;
import fr.eql.ai109.apptontapat.ibusiness.SlopeIbusiness;
import fr.eql.ai109.apptontapat.idao.SlopeIDao;

@Remote(SlopeIbusiness.class)
@Stateless
public class SlopeBusiness implements SlopeIbusiness{

	@EJB
	private SlopeIDao slopeIDao;
	
	@Override
	public List<Slope> extraireToutLesSlopes() {
		return slopeIDao.getAllSlope();
	}

}
