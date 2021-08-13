package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;
import java.util.Date;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;

public interface ServiceIBusiness {
	List<Herd> search(Field field);
	List<Float> distanceBU(Field field);
	List<Service> extraireToutesLesPrestations();
	List<Service> extraireToutesLesPrestationsParIdTroupeau(int id);
	List<Service> extraireToutesLesPrestationsParIdTerrain(int id);
	Service ajoutPrestation(Service service);
	Service annoterUnePrestation(Integer id, Integer rateNote, Date date, String rateComment);
	List<Service> getAllByIdAccount(int id);
}
