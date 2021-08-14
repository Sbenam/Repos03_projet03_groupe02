package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Rupture;
import fr.eql.ai109.apptontapat.ibusiness.RuptureIBusiness;
import fr.eql.ai109.apptontapat.idao.RuptureIDao;

@Remote(RuptureIBusiness.class)
@Stateless
public class RuptureBusiness implements RuptureIBusiness{

	@EJB
	private RuptureIDao ruptureIDao;
	
	@Override
	public List<Rupture> extraireToutesLesRupture() {
		return ruptureIDao.getAllComposition();
	}

	@Override
	public List<String> extraireToutesLesRuptureLabels() {
		return ruptureIDao.getAllCompositionLabels();
	}

	@Override
	public Rupture extraireRuptureAPartirDeLabel(String label) {
		// TODO Auto-generated method stub
		return ruptureIDao.getIdRuptureByLabel(label);
	}

}
