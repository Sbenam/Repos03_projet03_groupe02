package fr.eql.ai109.apptontapat.business;

import fr.eql.ai109.apptontapat.entity.Account;
import fr.eql.ai109.apptontapat.entity.ZipCode;
import fr.eql.ai109.apptontapat.ibusiness.AccountIBusiness;

public class ProgramTest {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		Account a = new Account("aaa", "dkkdkd", new ZipCode(555));
		
		AccountIBusiness ab = new AccountBusiness();	
		System.out.println(ab);
		ab.inscription(a);
	}

}
