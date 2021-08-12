package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Incident;

public interface IncidentIBusiness {
	Incident extraireIncidentParId(int id);
	Incident extraireIncidentParIdAccount(int id);
	List<Incident> extraireToutLesIncident();
	List<Incident> extraireToutLesIncidentParIdAccount(int id);
	Incident ajoutIncident(Incident incident);
	Incident mettreAJourUnIncident(Incident incident);

}
