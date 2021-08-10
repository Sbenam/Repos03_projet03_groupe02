package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Refusal;

public interface RefusalIDao extends GenericIDao<Refusal>{
	public List<Refusal> getAllRefusal();
}
