package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Incident;

public interface IncidentIDao extends GenericIDao<Incident>{
	public Incident getIncidentById(int id);
	public Incident getIncidentByIdService(int id);
	public List<Incident> getAll();
	public List<Incident> getAllByIdService(int id);
}
