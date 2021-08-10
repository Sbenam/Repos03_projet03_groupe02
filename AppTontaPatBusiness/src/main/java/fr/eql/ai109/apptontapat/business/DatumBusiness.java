package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Datum;
import fr.eql.ai109.apptontapat.ibusiness.DatumIBusiness;
import fr.eql.ai109.apptontapat.idao.DatumIDao;

@Remote(DatumIBusiness.class)
@Stateless
public class DatumBusiness implements DatumIBusiness{

	@EJB
	private DatumIDao datumIDao;
	
	@Override
	public List<Datum> extraireToutesLesDatum() {
		return datumIDao.getAllDatum();
	}

}
