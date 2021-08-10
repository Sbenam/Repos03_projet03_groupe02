package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Enclosure;

public interface EnclosureIbusiness {
	public List<Enclosure> extraireToutesLesEnclosures();
	public List<String> extraireToutesLesEnclosuresLabels();
}
