package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Desactivation;

public interface DesactivationIDao extends GenericIDao<Desactivation>{
	public List<Desactivation> getAllDesactivation();
}
