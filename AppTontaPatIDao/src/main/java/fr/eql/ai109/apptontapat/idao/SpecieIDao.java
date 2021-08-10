package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Specie;

public interface SpecieIDao extends GenericIDao<Specie>{
	public List<Specie> getAllSpecie();
	public List<String> getAllSpecieLabel();
}
