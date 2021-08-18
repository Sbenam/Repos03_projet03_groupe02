package fr.eql.ai109.apptontapat.business;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Clocking;
import fr.eql.ai109.apptontapat.ibusiness.ClockingIBusiness;
import fr.eql.ai109.apptontapat.idao.ClockingIDao;


@Remote(ClockingIBusiness.class)
@Stateless
public class ClockingBusiness implements ClockingIBusiness{

	@EJB
	private ClockingIDao clockingIDao;

	@Override
	public List<Clocking> extraireTouteLesraces() {
		return clockingIDao.getAll();
	}

	@Override
	public Clocking addClocking(Clocking clocking) {
		return clockingIDao.add(clocking);
	}

	@Override
	public List<Clocking> extraireTouteLesClockingViaIdService(int id) {
		return clockingIDao.getClockingByIdService(id);
	}

}
