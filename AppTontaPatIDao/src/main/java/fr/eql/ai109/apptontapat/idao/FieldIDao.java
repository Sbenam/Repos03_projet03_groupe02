package fr.eql.ai109.apptontapat.idao;

import fr.eql.ai109.apptontapat.entity.Field;

public interface FieldIDao extends GenericIDao<Field>{
	
	public Field getFieldById(int id);

}
