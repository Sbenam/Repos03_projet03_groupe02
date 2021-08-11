package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Composition;
import fr.eql.ai109.apptontapat.ibusiness.CompositionIBusiness;
import fr.eql.ai109.apptontapat.idao.CompositionIDao;


@Remote(CompositionIBusiness.class)
@Stateless
public class CompositionBusiness implements CompositionIBusiness{

	@EJB
	private CompositionIDao compositionIDao;
	

	@Override
	public List<Composition> extraireToutesLesComposition() {
		return compositionIDao.getAllComposition();
	}


	@Override
	public List<String> extraireToutesLesCompositionLabels() {
		return compositionIDao.getAllCompositionLabels();
	}

}
