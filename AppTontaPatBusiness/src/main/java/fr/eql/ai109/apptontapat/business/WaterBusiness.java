package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Water;
import fr.eql.ai109.apptontapat.ibusiness.WaterIBusiness;
import fr.eql.ai109.apptontapat.idao.WaterIDao;

@Remote(WaterIBusiness.class)
@Stateless
public class WaterBusiness implements WaterIBusiness{

	@EJB
	private WaterIDao waterIDao;
	
	@Override
	public List<Water> extraireToutLesWater() {
		return waterIDao.getAllWater();
	}

}
