package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.HerdIbusiness;
import fr.eql.ai109.apptontapat.idao.HerdIDao;


@Remote(HerdIbusiness.class)
@Stateless
public class HerdBusiness implements HerdIbusiness{

	@EJB
	private HerdIDao herdIDao;
	
	@Override
	public Herd extraireTroupeauParId(int id) {
		// TODO Auto-generated method stub
		return herdIDao.getHerdById(id);
	}

	@Override
	public Herd extraireTroupeauParIdAccount(int id) {
		// TODO Auto-generated method stub
		return herdIDao.getHerdByIdAccount(id);
	}

	@Override
	public List<Herd> extraireToutLesTroupeaux() {
		// TODO Auto-generated method stub
		return herdIDao.getAllHerd();
	}

	@Override
	public List<Herd> extraireToutLesTroupeauxParIdAccount(int id) {
		// TODO Auto-generated method stub
		return herdIDao.getAllHerdByIdAccount(id);
	}

	@Override
	public Herd ajoutTroupeau(Herd herd) {
		return herdIDao.add(herd);
	}

	@Override
	public Herd mettreAJourUnTroupeau(Herd herd) {
		return herdIDao.update(herd);
	}

}
