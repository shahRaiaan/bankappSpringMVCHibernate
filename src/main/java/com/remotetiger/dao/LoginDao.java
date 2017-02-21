package com.remotetiger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.remotetiger.bankapp.Customer;
import com.remotetiger.bankapp.Login;

public class LoginDao {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public int validate(String username, String password) {
		int found = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		Login login = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Login.class);
			cr.add(Restrictions.eq("username", username));
			cr.add(Restrictions.eq("password", password));
			List<Login> results = (List<Login>) cr.list();

			for (Login x : results) {
				login = x;
			}

			tx.commit();
			if (results.isEmpty() == false) {

				found = login.getId();
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return found;
	}

}
