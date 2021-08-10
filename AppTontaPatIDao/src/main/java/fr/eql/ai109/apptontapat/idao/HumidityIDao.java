package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Humidity;

public interface HumidityIDao extends GenericIDao<Humidity>{
	public List<Humidity> getAllHumidity();
	public List<String> getAllHumidityLabel();
}
