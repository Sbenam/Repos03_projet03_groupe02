package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Field;

public interface FieldIDao extends GenericIDao<Field>{
	
	public Field getFieldById(int id);
	public Field getFieldByIdAccount(int id);
	public Field removeFieldById(int id);
	public Field removeFieldByIdAccount(int id);
	public List<Field> getAll();
	public List<Field> getAllByIdAccount(int id);
	public Field retirerField(String label, Integer id);
}
