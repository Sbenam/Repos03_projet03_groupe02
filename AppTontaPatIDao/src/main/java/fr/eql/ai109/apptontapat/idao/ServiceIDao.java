package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface ServiceIDao extends GenericIDao<Service> {

	List<Herd> search(Field field);
//	List<ZipCode> search(Field field);
	List<Herd> search(Double latitude, Double longitude);
	List<Float> distances(Field field);
	
}
