package fr.eql.ai109.apptontapat.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.Field;
import fr.eql.ai109.apptontapat.entity.Herd;
import fr.eql.ai109.apptontapat.entity.Service;
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

	@Override
	public Account extraireCompteAvecId(int id) {
		return aidao.getAccountById(id);
	}

	@Override
	public List<Service> getFieldWaiting(int id) {
		return aidao.getFieldWaiting(id);
	}

	@Override
	public List<Service> getFieldRefuse(int id) {
		return aidao.getFieldRefuse(id);
	}

	@Override
	public List<Service> getFieldEnCour(int id) {
		return aidao.getFieldEnCour(id);
	}

	@Override
	public List<Service> getFieldBreak(int id) {
		return aidao.getFieldBreak(id);
	}

	@Override
	public List<Service> getFieldFinish(int id) {
		return aidao.getFieldFinish(id);
	}

	@Override
	public List<Service> getHerdWaiting(int id) {
		return aidao.getHerdWaiting(id);
	}

	@Override
	public List<Service> getHerdRefuse(int id) {
		return aidao.getHerdRefuse(id);
	}

	@Override
	public List<Service> getHerdEnCour(int id) {
		return aidao.getHerdEnCour(id);
	}

	@Override
	public List<Service> getHerdBreak(int id) {
		return aidao.getHerdBreak(id);
	}

	@Override
	public List<Service> getHerdFinish(int id) {
		return aidao.getHerdFinish(id);
	}


	@Override
	public List<Service> listHerdServiceInProgress(int id) {
		List<Service> services = aidao.getAllServiceHerd(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()!=null)&&(service.getRefusal()==null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listHerdServiceRefusal(int id) {
		List<Service> services = aidao.getAllServiceHerd(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()==null)&&(service.getRefusal()!=null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}


	@Override
	public List<Service> listHerdServiceWaiting(int id) {
		List<Service> services = aidao.getAllServiceHerd(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()==null)&&(service.getRefusal()==null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listHerdServiceFinish(int id) {
		List<Service> services = aidao.getAllServiceHerd(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()!=null)&&(service.getRefusal()==null)&&(service.getFinished()!=null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listFieldServiceWaiting(int id) {
		List<Service> services = aidao.getAllServiceField(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()==null)&&(service.getRefusal()==null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listFieldServiceRefusal(int id) {
		List<Service> services = aidao.getAllServiceField(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()==null)&&(service.getRefusal()!=null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listFieldServiceInProgress(int id) {
		List<Service> services = aidao.getAllServiceField(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()!=null)&&(service.getRefusal()==null)&&(service.getRupture()==null)&&(service.getFinished()==null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

	@Override
	public List<Service> listFieldServiceFinish(int id) {
		List<Service> services = aidao.getAllServiceField(id);
		List<Service> servicesR = new ArrayList<Service>();
		for (Service service : services) {
			if((service.getValidation()!=null)&&(service.getRefusal()==null)&&(service.getFinished()!=null)) {
				servicesR.add(service);
			}
		}
		return servicesR;
	}

}