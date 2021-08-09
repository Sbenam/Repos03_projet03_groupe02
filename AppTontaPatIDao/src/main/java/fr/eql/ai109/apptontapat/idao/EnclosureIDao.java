package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Enclosure;

public interface EnclosureIDao extends GenericIDao<Enclosure>{
	List<Enclosure> getAllEnclosure();
}
