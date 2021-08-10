package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Vegetation;

public interface VegetationIBusiness {
	List<Vegetation> extraireToutesLesVegetation();
	List<String> extraireToutesLesVegetationLabels();
}
