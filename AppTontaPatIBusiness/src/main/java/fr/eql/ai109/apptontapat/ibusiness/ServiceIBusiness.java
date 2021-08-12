package fr.eql.ai109.apptontapat.ibusiness;


import java.util.Date;
import java.util.List;
import fr.eql.ai109.apptontapat.entity.Service;

public interface ServiceIBusiness {
	List<Service> extraireToutesLesPrestations();
	List<Service> extraireToutesLesPrestationsParIdTroupeau(int id);
	List<Service> extraireToutesLesPrestationsParIdTerrain(int id);
	Service ajoutPrestation(Service service);
	Service annoterUnePrestation(Integer id, Integer rateNote, Date date, String rateComment);
}
