package fr.eql.ai109.apptontapat.ibusiness;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;

public interface AccountIBusiness {

	// En a t'on reéllement besoin !
	Boolean exists(String email);

	Account inscription(Account account);
	
	Account connection(String login, String password);
	
	Account mettreAjourUnCompte(Account account);
	
	Account extraireCompteAvecId(int id);

	List<Service> getFieldWaiting(int id);

	List<Service> getFieldRefuse(int id);
	
	List<Service> getFieldEnCour(int id);
	
	List<Service> getFieldBreak(int id);
	
	List<Service> getFieldFinish(int id);

	List<Service> getHerdWaiting(int id);

	List<Service> getHerdRefuse(int id);

	List<Service> getHerdEnCour(int id);
	
	List<Service> getHerdBreak(int id);
	
	List<Service> getHerdFinish(int id);

	List<Service> listHerdServiceInProgress(int id);
	
	List<Service> listHerdServiceRefusal(int id);
	
	List<Service> listHerdServiceWaiting(int id);
	
	List<Service> listHerdServiceFinish(int id);

	List<Service> listFieldServiceInProgress(int id);
	
	List<Service> listFieldServiceRefusal(int id);
	
	List<Service> listFieldServiceWaiting(int id);
	
	List<Service> listFieldServiceFinish(int id);

	//	List<Account> findAll();

}
