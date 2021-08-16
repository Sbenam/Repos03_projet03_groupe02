package fr.eql.ai109.apptontapat.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.idao.AccountIDao;

@Remote(AccountIDao.class)
@Stateless
public class AccountDao extends GenericDao<Account> implements AccountIDao{

	@Override
	public Boolean exists(String email) {
		List<Account> accounts = null;

		Query query = em.createQuery(" SELECT a FROM Account a WHERE a.email=:emailParam ");
		query.setParameter("emailParam", email);
		accounts = query.getResultList();
		
		return accounts.size() > 0;
	}

	@Override
	public Account authenticate(String email, String password) {
		Account account = null;
		List<Account> accounts = null;
			Query query = em.createQuery(" SELECT a FROM Account a WHERE a.email=:emailParam AND a.password=:passwordParam ");
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

	@Override
	public Account getAccountById(int id) {
		List<Account> accounts = null;
		Account account = null;
		Query query = em.createQuery("SELECT u FROM Account u WHERE u.id=:idParam");
		query.setParameter("idParam",id);
		accounts= (List<Account>)query.getResultList();
		if (accounts.size() > 0) {
			account =accounts.get(0);
		}
		return account;
	}


	@Override
	public List<Field> getFieldWaiting(int id) {
		Query query = em.createQuery("SELECT DISTINCT f "
				+ "FROM Field f JOIN Service s ON f.id = s.field.id "
				+ "WHERE f.retret is null "
				+ "AND s.validation is null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND f.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Field>)query.getResultList();		
	}
	

	@Override
	public List<Field> getFieldRefuse(int id) {
		Query query = em.createQuery("SELECT DISTINCT f "
				+ "FROM Field f JOIN Service s ON f.id = s.field.id "
				+ "WHERE f.retret is null "
				+ "AND s.validation is null "
				+ "AND s.refusal is not null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND f.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Field>)query.getResultList();		
	}
	

	@Override
	public List<Field> getFieldEnCour(int id) {
		Query query = em.createQuery("SELECT DISTINCT f "
				+ "FROM Field f JOIN Service s ON f.id = s.field.id "
				+ "WHERE f.retret is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND f.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Field>)query.getResultList();		
	}
	

	@Override
	public List<Field> getFieldBreak(int id) {
		Query query = em.createQuery("SELECT DISTINCT f "
				+ "FROM Field f JOIN Service s ON f.id = s.field.id "
				+ "WHERE f.retret is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is not null "
				+ "AND s.finished is null "
				+ "AND f.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Field>)query.getResultList();		
	}
	

	@Override
	public List<Field> getFieldFinish(int id) {
		Query query = em.createQuery("SELECT DISTINCT f "
				+ "FROM Field f JOIN Service s ON f.id = s.field.id "
				+ "WHERE f.retret is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is not null "
				+ "AND f.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Field>)query.getResultList();		
	}

	@Override
	public List<Herd> getHerdWaiting(int id) {
		Query query = em.createQuery("SELECT DISTINCT h "
				+ "FROM Herd h JOIN Service s ON h.id = s.herd.id "
				+ "WHERE h.withdraw is null "
				+ "AND s.validation is null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND h.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Herd>)query.getResultList();
	}

	@Override
	public List<Herd> getHerdRefuse(int id) {
		Query query = em.createQuery("SELECT DISTINCT h "
				+ "FROM Herd h JOIN Service s ON h.id = s.herd.id "
				+ "WHERE h.withdraw is null "
				+ "AND s.validation is null "
				+ "AND s.refusal is not null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND h.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Herd>)query.getResultList();
	}

	@Override
	public List<Herd> getHerdEnCour(int id) {
		Query query = em.createQuery("SELECT DISTINCT h "
				+ "FROM Herd h JOIN Service s ON h.id = s.herd.id "
				+ "WHERE h.withdraw is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is null "
				+ "AND h.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Herd>)query.getResultList();
	}

	@Override
	public List<Herd> getHerdBreak(int id) {
		Query query = em.createQuery("SELECT DISTINCT h "
				+ "FROM Herd h JOIN Service s ON h.id = s.herd.id "
				+ "WHERE h.withdraw is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is not null "
				+ "AND s.finished is null "
				+ "AND h.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Herd>)query.getResultList();
	}

	@Override
	public List<Herd> getHerdFinish(int id) {
		Query query = em.createQuery("SELECT DISTINCT h "
				+ "FROM Herd h JOIN Service s ON h.id = s.herd.id "
				+ "WHERE h.withdraw is null "
				+ "AND s.validation is not null "
				+ "AND s.refusal is null "
				+ "AND s.rupture is null "
				+ "AND s.finished is not null "
				+ "AND h.account.id = :idParam ");
		query.setParameter("idParam",id);
		return (List<Herd>)query.getResultList();
	}

}
