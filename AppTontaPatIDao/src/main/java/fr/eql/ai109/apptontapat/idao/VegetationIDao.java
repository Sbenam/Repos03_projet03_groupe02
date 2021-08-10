package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Vegetation;

public interface VegetationIDao extends GenericIDao<Vegetation> {
	public List<Vegetation> getAllVegetation();
}
