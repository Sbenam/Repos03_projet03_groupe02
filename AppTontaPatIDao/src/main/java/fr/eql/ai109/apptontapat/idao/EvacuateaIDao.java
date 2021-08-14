package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.EvacuateA;

public interface EvacuateaIDao extends GenericIDao<EvacuateA>{
	public List<EvacuateA> getAllEvacuatea();
	public List<String> getAllEvacuateaLabels();
	public EvacuateA getIdEvacuateaByLabel(String label);
}
