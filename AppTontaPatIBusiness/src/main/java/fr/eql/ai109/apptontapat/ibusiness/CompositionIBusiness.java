package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Composition;

public interface CompositionIBusiness {
	List<Composition> extraireToutesLesComposition();
	List<String> extraireToutesLesCompositionLabels();
}
