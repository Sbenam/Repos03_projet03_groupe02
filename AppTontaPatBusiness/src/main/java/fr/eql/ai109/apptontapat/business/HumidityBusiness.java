package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Humidity;
import fr.eql.ai109.apptontapat.ibusiness.HumidityIBusiness;
import fr.eql.ai109.apptontapat.idao.HumidityIDao;

@Remote(HumidityIBusiness.class)
@Stateless
public class HumidityBusiness implements HumidityIBusiness{

	@EJB
	private HumidityIDao humidityIDao;
	
	@Override
	public List<Humidity> extraireToutLesHumidity() {
		return humidityIDao.getAllHumidity();
	}

}
