package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.TakeOut;

public interface TakeoutIDao extends GenericIDao<TakeOut>{
	public List<TakeOut> getAllTakeOut();
	public List<String> getAllTakeOutLabels();
}
