package com.remotetiger.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.remotetiger.bankapp.Customer;

import com.remotetiger.bankapp.Customer;

public class CustomerDao {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public Integer addCustomer(Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer customerID = null;
		try {
			tx = session.beginTransaction();
			customerID = (Integer) session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerID;
	}

	public Customer getCustomerById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		Customer customer = null;
		try {
			tx = session.beginTransaction();
			customer = (Customer) session.get(Customer.class, id);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customer;
	}
}