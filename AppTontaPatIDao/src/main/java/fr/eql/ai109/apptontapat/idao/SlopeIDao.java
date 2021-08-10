package fr.eql.ai109.apptontapat.idao;

import java.util.List;


import fr.eql.ai109.apptontapat.entity.Slope;

public interface SlopeIDao extends GenericIDao<Slope>{
	public List<Slope> getAllSlope();
}
