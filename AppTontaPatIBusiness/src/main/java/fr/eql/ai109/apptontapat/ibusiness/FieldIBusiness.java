package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Field;

public interface FieldIBusiness {
	Field extraireTerrainParId(int id);
	Field extraireTerrainParIdAccount(int id);
	List<Field> extraireToutLesTerrain();
	List<Field> extraireToutLesTerrainParIdAccount(int id);
}
