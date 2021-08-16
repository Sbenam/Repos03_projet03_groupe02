package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;

public interface AccountIBusiness {

	// En a t'on reéllement besoin !
	Boolean exists(String email);

	Account inscription(Account account);
	
	Account connection(String login, String password);
	
	Account mettreAjourUnCompte(Account account);
	
	Account extraireCompteAvecId(int id);

	List<Field> getFieldWaiting(int id);

	List<Field> getFieldRefuse(int id);
	
	List<Field> getFieldEnCour(int id);
	
	List<Field> getFieldBreak(int id);
	
	List<Field> getFieldFinish(int id);

//	List<Account> findAll();

}
