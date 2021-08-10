package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Water;



public interface WaterIBusiness {
	List<Water> extraireToutLesWater();
	List<String> extraireToutLesWaterLabels();
}
