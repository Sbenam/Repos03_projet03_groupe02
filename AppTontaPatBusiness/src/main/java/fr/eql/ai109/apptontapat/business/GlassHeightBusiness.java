package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.GlassHeight;
import fr.eql.ai109.apptontapat.ibusiness.GlassHeightIbusiness;
import fr.eql.ai109.apptontapat.idao.GlassHeightIDao;

@Remote(GlassHeightIbusiness.class)
@Stateless
public class GlassHeightBusiness implements GlassHeightIbusiness{

	@EJB
	private GlassHeightIDao glassHeightIDao;
	
	@Override
	public List<GlassHeight> extraireToutLesGlassHeight() {
		return glassHeightIDao.getAllGlassHeight();
	}

}
