package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Herd;

public interface HerdIbusiness {
	Herd extraireTroupeauParId(int id);
	Herd extraireTroupeauParIdAccount(int id);
	List<Herd> extraireToutLesTroupeaux();
	List<Herd> extraireToutLesTroupeauxParIdAccount(int id);
}
