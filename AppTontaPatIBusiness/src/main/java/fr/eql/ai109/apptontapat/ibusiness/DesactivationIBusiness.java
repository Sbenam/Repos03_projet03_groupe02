package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Desactivation;

public interface DesactivationIBusiness {
	List<Desactivation> extraireToutesLesDesactivation();
	List<String> extraireToutesLesDesactivationLabels();
}
