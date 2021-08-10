package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.GlassHeight;

public interface GlassHeightIDao extends GenericIDao<GlassHeight>{
	public List<GlassHeight> getAllGlassHeight();
	public List<String> getAllGlassHeightLabel();
}
