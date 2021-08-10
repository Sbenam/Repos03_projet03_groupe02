package fr.eql.ai109.apptontapat.idao;

import java.util.List;
import fr.eql.ai109.apptontapat.entity.Rupture;

public interface RuptureIDao extends GenericIDao<Rupture>{
	public List<Rupture> getAllComposition();
	public List<String> getAllCompositionLabels();
}
