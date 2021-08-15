package fr.eql.ai109.apptontapat.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai109.apptontapat.entity.Clocking;
import fr.eql.ai109.apptontapat.idao.ClockingIDao;

@Remote(ClockingIDao.class)
@Stateless
public class ClockingDao extends GenericDao<Clocking> implements ClockingIDao{
	
	@PersistenceContext(unitName = "AppTontaPat")
	protected EntityManager em;

}
