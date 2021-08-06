package fr.eql.ai109.apptontapat.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;
import fr.eql.ai109.apptontapat.idao.AccountIDao;


@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {

	@EJB
	private AccountIDao aidao;
	
	@Override
	public Account inscription(Account account) {
		return aidao.add(account);
	}

//	@Override
//	public void inscription(Account account) {
//		aidao.add(account);
//	}
	
//	public Account connection(String login, String password) {
//		return aidao.authenticate(login, password);
//	}

	@Override
	public Account connection(String login, String password) {
		return null;
	}
	
}

