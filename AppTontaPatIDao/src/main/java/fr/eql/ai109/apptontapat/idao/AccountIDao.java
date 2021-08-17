package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface AccountIDao extends GenericIDao<Account>{

	Boolean exists(String email);
	Account authenticate(String email, String password);
	Long getNbUsers();
	Account getAccountById(int id);
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
	
}