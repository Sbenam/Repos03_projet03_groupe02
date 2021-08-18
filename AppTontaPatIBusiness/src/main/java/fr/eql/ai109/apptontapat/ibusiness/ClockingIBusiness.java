package fr.eql.ai109.apptontapat.ibusiness;


import java.util.List;

import fr.eql.ai109.apptontapat.entity.Clocking;


public interface ClockingIBusiness {
	public List<Clocking> extraireTouteLesraces();
	public List<Clocking> extraireTouteLesClockingViaIdService(int id);
	public Clocking addClocking(Clocking clocking);
}
