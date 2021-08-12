package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import java.util.Date;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;

public interface ServiceIDao extends GenericIDao<Service> {

	List<Herd> search(Field field);
	List<Herd> search(Double latitude, Double longitude);
	public List<Service> getAllByIdHerd(int id);
	public List<Service> getAllByIdField(int id);
	public Service annotedService(Integer id, Integer rateNote, Date rateDate, String rateComment);
}
