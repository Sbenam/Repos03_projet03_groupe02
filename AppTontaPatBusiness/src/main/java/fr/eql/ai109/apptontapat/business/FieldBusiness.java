package fr.eql.ai109.apptontapat.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.ibusiness.FieldIBusiness;
import fr.eql.ai109.apptontapat.idao.FieldIDao;

@Remote(FieldIBusiness.class)
@Stateless
public class FieldBusiness implements FieldIBusiness{

	@EJB
	private FieldIDao fieldIDao;
	
	@Override
	public Field extraireTerrainParId(int id) {
		// TODO Auto-generated method stub
		return fieldIDao.getFieldById(id);
	}

}
