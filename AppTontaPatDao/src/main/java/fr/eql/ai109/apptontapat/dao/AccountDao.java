package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.idao.AccountIDao;

@Remote(AccountIDao.class)
@Stateless
public class AccountDao extends GenericDao<Account> implements AccountIDao{

	@Override
	public Boolean exists(Account account) {
		List<Account> accounts = null;

		Query query = em.createQuery("SELECT a FROM Account a WHERE a.email=:emailParam");
		query.setParameter("emailParam", account.getEmail());
		accounts = query.getResultList();
		
		return accounts.size() > 0;
	}

	@Override
	public Account authenticate(String email, String password) {
		Account account = null;
		List<Account> accounts = null;
			Query query = em.createQuery("SELECT a FROM Account a WHERE a.email=:emailParam"
					+ " AND a.password=:passwordParam");
			query.setParameter("emailParam", email);
			query.setParameter("passwordParam", password);
			accounts = query.getResultList();
			if (accounts.size() > 0) {
				account =accounts.get(0);
			}
		return account;
	}

	@Override
	public Long getNbUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
