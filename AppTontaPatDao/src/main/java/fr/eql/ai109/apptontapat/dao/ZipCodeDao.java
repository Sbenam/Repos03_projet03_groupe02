package fr.eql.ai109.apptontapat.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.idao.ZipCodeIDao;

@Remote(ZipCodeIDao.class)
@Stateless
public class ZipCodeDao extends GenericDao<ZipCode> implements ZipCodeIDao{

}
