package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import java.util.Date;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface ServiceIDao extends GenericIDao<Service> {

	List<Herd> search(Field field);
//	List<ZipCode> search(Field field);
	List<Herd> search(Double latitude, Double longitude);
	List<Float> distances(Field field);
	public List<Service> getAllByIdHerd(int id);
	public List<Service> getAllByIdField(int id);
	public Service annotedService(Integer id, Integer rateNote, Date rateDate, String rateComment);
}
