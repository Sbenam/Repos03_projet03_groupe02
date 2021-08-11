package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Race;

public interface RaceIDao extends GenericIDao<Race>{
	public List<Race> getAllRace();
	public List<String> getAllRaceLabels();
}
