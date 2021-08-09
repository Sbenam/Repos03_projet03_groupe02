package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Water;

public interface WaterIDao extends GenericIDao<Water>{
	public List<Water> getAllWater();
}
