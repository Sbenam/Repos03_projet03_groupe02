package fr.eql.ai109.apptontapat.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.idao.AccountIDao;

@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {

	@EJB
	private AccountIDao aidao;

	// En a t'on reéllement besoin !
	@Override
	public Boolean exists(String email) {
		return aidao.exists(email);
	}

	@Override
	public Account inscription(Account account) {
		// return (aidao.exists(account)?null:aidao.add(account));
		return aidao.add(account);
	}

	@Override
	public Account connection(String email, String password) {
		return aidao.authenticate(email, password);
	}


	@Override
	public Account mettreAjourUnCompte(Account account) {
		return aidao.update(account);
	}

	@Override
	public Account extraireCompteAvecId(int id) {
		return aidao.getAccountById(id);
	}

	@Override
	public List<Field> getFieldWaiting(int id) {
		return aidao.getFieldWaiting(id);
	}

	@Override
	public List<Field> getFieldRefuse(int id) {
		return aidao.getFieldRefuse(id);
	}

	@Override
	public List<Field> getFieldEnCour(int id) {
		return aidao.getFieldEnCour(id);
	}

	@Override
	public List<Field> getFieldBreak(int id) {
		return aidao.getFieldBreak(id);
	}

	@Override
	public List<Field> getFieldFinish(int id) {
		return aidao.getFieldFinish(id);
	}

	@Override
	public List<Herd> getHerdWaiting(int id) {
		return aidao.getHerdWaiting(id);
	}

	@Override
	public List<Herd> getHerdRefuse(int id) {
		return aidao.getHerdRefuse(id);
	}

	@Override
	public List<Herd> getHerdEnCour(int id) {
		return aidao.getHerdEnCour(id);
	}

	@Override
	public List<Herd> getHerdBreak(int id) {
		return aidao.getHerdBreak(id);
	}

	@Override
	public List<Herd> getHerdFinish(int id) {
		return aidao.getHerdFinish(id);
	}

}