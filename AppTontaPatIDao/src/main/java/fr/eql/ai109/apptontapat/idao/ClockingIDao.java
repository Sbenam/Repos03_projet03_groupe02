package fr.eql.ai109.apptontapat.idao;


import java.util.List;

import fr.eql.ai109.apptontapat.entity.Clocking;

public interface ClockingIDao extends GenericIDao<Clocking>{
	List<Clocking> getClockingByIdService(int id);
}
