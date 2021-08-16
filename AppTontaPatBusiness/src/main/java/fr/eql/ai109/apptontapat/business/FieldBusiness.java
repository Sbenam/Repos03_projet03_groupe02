package fr.eql.ai109.apptontapat.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
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

	@Override
	public Field extraireTerrainParIdAccount(int id) {
		return fieldIDao.getFieldByIdAccount(id);
	}

	@Override
	public List<Field> extraireToutLesTerrain() {
		
		return fieldIDao.getAll();
	}

	@Override
	public List<Field> extraireToutLesTerrainParIdAccount(int id) {

		return fieldIDao.getAllByIdAccount(id);
	}

	@Override
	public Field ajoutTerrain(Field field) {
		return fieldIDao.add(field);
	}

	@Override
	public Field mettreAJourUnTerrain(Field field) {
		return fieldIDao.update(field);
	}

	@Override
	public void supprimerTerrain(Field field) {
		fieldIDao.delete(field);
	}


}
