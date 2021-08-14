package fr.eql.ai109.apptontapat.idao;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface AccountIDao extends GenericIDao<Account>{

	Boolean exists(String email);
	Account authenticate(String email, String password);
	Long getNbUsers();
	Account getAccountById(int id);
	
}