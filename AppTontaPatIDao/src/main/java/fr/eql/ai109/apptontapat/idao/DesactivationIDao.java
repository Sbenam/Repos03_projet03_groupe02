package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Desactivation;
import fr.eql.ai109.apptontapat.entity.Retret;

public interface DesactivationIDao extends GenericIDao<Desactivation>{
	public List<Desactivation> getAllDesactivation();
	public List<String> getAllDesactivationLabels();
	public Desactivation getIdDesactivationByLabel(String label);
}
