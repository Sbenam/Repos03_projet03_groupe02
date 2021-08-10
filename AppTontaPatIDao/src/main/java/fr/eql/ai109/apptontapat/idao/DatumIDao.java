package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Datum;

public interface DatumIDao extends GenericIDao<Datum>{
	public List<Datum> getAllDatum();
	public List<String> getAllDatumLabels();
}
