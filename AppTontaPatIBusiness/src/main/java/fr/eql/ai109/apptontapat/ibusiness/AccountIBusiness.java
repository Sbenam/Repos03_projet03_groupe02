package fr.eql.ai109.apptontapat.ibusiness;

import fr.eql.ai109.apptontapat.entity.Account;

public interface AccountIBusiness {
	
	Account inscription(Account account);
	
	Account connection(String login, String password);
//	List<Account> findAll();

}
