package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;

public interface ServiceIBusiness {
	List<Herd> search(Field field);
//	List<ZipCode> search(Field field);
	List<Herd> search(Double latitude, Double longitude);
}
