package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Rupture;

public interface RuptureIBusiness {
	List<Rupture> extraireToutesLesRupture();
	List<String> extraireToutesLesRuptureLabels();
	Rupture extraireRuptureAPartirDeLabel(String label);
}
