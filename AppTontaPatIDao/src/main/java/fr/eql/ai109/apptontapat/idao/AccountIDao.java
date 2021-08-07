package fr.eql.ai109.apptontapat.idao;

import fr.eql.ai109.apptontapat.entity.Account;

public interface AccountIDao extends GenericIDao<Account>{

	Boolean exists(Account account);
	Account authenticate(String email, String password);
	Long getNbUsers();
	
}