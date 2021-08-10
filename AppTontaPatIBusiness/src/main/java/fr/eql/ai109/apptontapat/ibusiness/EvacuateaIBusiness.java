package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.EvacuateA;

public interface EvacuateaIBusiness {
	List<EvacuateA> extraireToutesLesEvacuateA();
	List<String> extraireToutesLesEvacuateALabels();
}
