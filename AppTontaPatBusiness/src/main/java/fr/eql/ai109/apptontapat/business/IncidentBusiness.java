package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Incident;
import fr.eql.ai109.apptontapat.ibusiness.IncidentIBusiness;
import fr.eql.ai109.apptontapat.idao.IncidentIDao;

@Remote(IncidentIBusiness.class)
@Stateless
public class IncidentBusiness implements IncidentIBusiness{

	@EJB
	private IncidentIDao incidentIDao;
	
	@Override
	public Incident extraireIncidentParId(int id) {
		return incidentIDao.getById(id);
	}

	@Override
	public Incident extraireIncidentParIdAccount(int id) {
		return incidentIDao.getIncidentByIdService(id);
	}

	@Override
	public List<Incident> extraireToutLesIncident() {
		return incidentIDao.getAll();
	}

	@Override
	public List<Incident> extraireToutLesIncidentParIdAccount(int id) {
		return incidentIDao.getAllByIdService(id);
	}

	@Override
	public Incident ajoutIncident(Incident incident) {
		return incidentIDao.add(incident);
	}

	@Override
	public Incident mettreAJourUnIncident(Incident incident) {
		return incidentIDao.update(incident);
	}

}
