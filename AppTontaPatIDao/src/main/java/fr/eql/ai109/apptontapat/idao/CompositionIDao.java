package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Composition;

public interface CompositionIDao extends GenericIDao<Composition>{
	public List<Composition> getAllComposition();
}
