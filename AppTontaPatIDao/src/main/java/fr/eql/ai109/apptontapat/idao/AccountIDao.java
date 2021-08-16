package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.ZipCode;

public interface AccountIDao extends GenericIDao<Account>{

	Boolean exists(String email);
	Account authenticate(String email, String password);
	Long getNbUsers();
	Account getAccountById(int id);
	List <Herd> getHerdWaiting(int id);
	List <Herd> getHerdRefuse(int id);
	List <Herd> getHerdEnCour(int id);
	List <Herd> getHerdBreak(int id);
	List <Herd> getHerdFinish(int id);
	
}