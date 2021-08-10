package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Datum;

public interface DatumIBusiness {
	List<Datum> extraireToutesLesDatum();
	List<String> extraireToutesLesDatumLabels();
}
