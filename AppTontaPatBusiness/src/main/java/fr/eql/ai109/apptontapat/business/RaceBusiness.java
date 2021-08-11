package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Race;
import fr.eql.ai109.apptontapat.ibusiness.RaceIBusiness;
import fr.eql.ai109.apptontapat.idao.RaceIDao;

@Remote(RaceIBusiness.class)
@Stateless
public class RaceBusiness implements RaceIBusiness{

	@EJB
	private RaceIDao raceIDao;
	
	@Override
	public List<Race> extraireTouteLesraces() {
		return raceIDao.getAllRace();
	}

	@Override
	public List<String> extraireTouteLesracesLabels() {
		return raceIDao.getAllRaceLabels();
	}

}
