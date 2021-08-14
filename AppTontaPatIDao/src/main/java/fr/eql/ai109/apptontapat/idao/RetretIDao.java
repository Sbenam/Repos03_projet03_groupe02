package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Retret;

public interface RetretIDao extends GenericIDao<Retret> {
	public List<Retret> getAllRetret();
	public List<String> getAllRetretLabels();
	public Retret getIdRetretByLabel(String label);
}
