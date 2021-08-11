package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Retret;



public interface RetretIBusiness {
	List<Retret> extraireToutLesRetret();
	List<String> extraireToutLesRetretLabels();
}
