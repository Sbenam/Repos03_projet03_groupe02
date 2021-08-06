package fr.eql.ai109.apptontapat.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.idao.AccountIDao;

@Remote(AccountIDao.class)
@Stateless
public class AccountDao extends GenericDao<Account> implements AccountIDao{

}
