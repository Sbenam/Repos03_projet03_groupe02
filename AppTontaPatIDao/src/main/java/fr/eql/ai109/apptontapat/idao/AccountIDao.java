package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface AccountIDao extends GenericIDao<Account>{

	Boolean exists(String email);
	Account authenticate(String email, String password);
	Long getNbUsers();
	Account getAccountById(int id);
	List<Field> getFieldWaiting(int id);
	List<Field> getFieldRefuse(int id);
	List<Field> getFieldEnCour(int id);
	List<Field> getFieldBreak(int id);
	List<Field> getFieldFinish(int id);
	
}