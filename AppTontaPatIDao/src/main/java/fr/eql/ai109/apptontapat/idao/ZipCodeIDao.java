package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface ZipCodeIDao extends GenericIDao<ZipCode> {
	List<String> getAllCity();
	String getCityByCode(String code);
	ZipCode getZipCodeById(int id);
}
