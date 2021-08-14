package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.TakeOut;

public interface TakeoutIBusiness {
	List<TakeOut> extraireToutesLesTakeout();
	List<String> extraireToutesLesTakeoutLabels();
	public TakeOut extraireTakeoutAPartirDeLabel(String label);
}
