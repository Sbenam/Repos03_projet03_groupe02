package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Shelter;

public interface ShelterIDao extends GenericIDao<Shelter>{
	public List<Shelter> getAllShelter();
}
