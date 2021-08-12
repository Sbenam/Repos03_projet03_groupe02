package fr.eql.ai109.apptontapat.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
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
}