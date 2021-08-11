package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface ZipCodeIBusiness {
	List<ZipCode> getAllBu();
	List<String> getAllBuCity();
	String extraireVilleAvecCodePostale(String code);
}
