package com.remotetiger.bankapp;

import com.remotetiger.dao.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*import com.remotetiger.dao.CustomerDao;
import com.remotetiger.dao.HibernateUtil;
import com.remotetiger.dao.LoginDao;*/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Login log = new Login("Raiaan", "pass123", "How are you", "I am fine");
		Address address = new Address("Mandan Rd", 7807, 3456);
		Customer customer = new Customer("Raiaan Shah", "7/4/90", address, log);

		CustomerDao dao = new CustomerDao();*/
		LoginDao dao = new LoginDao();
		
		System.out.println(dao.validate("Raiaan", "pas123"));

	}

}
