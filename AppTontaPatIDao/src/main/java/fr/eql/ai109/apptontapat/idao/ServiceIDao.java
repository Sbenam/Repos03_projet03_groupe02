package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Service;

public interface ServiceIDao extends GenericIDao<Service>{
	public List<Service> getAllByIdHerd(int id);
	public List<Service> getAllByIdField(int id);

}
