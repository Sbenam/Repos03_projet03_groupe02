package fr.eql.ai109.apptontapat.business;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.apptontapat.ibusiness.ServiceIBusiness;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness {

	
}
