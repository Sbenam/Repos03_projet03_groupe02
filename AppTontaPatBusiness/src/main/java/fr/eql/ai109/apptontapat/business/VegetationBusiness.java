package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Vegetation;
import fr.eql.ai109.apptontapat.ibusiness.VegetationIBusiness;
import fr.eql.ai109.apptontapat.idao.VegetationIDao;

@Remote(VegetationIBusiness.class)
@Stateless
public class VegetationBusiness implements VegetationIBusiness{
	
	@EJB
	private VegetationIDao vegetationIDao;



	@Override
	public List<Vegetation> extraireToutesLesVegetation() {
		return vegetationIDao.getAllVegetation();
	}



	@Override
	public List<String> extraireToutesLesVegetationLabels() {
		return vegetationIDao.getAllVegetationLabel();
	}

}
