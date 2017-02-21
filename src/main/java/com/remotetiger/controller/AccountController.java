package com.remotetiger.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.remotetiger.bankapp.Address;
import com.remotetiger.bankapp.Customer;
import com.remotetiger.bankapp.Login;
import com.remotetiger.dao.CustomerDao;

@Controller
public class AccountController {
	@Autowired
	private HttpServletRequest httpRequest;

	@RequestMapping(value = "/createaccount.html")
	public ModelAndView helloWorld() {

		return new ModelAndView("createAccount.jsp");
	}
	@RequestMapping(value = "/registeraccount.html")
	public ModelAndView registerAccount() {
		
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		String securityQuestion = httpRequest.getParameter("securityquestion");
		String securityAnswer = httpRequest.getParameter("securityanswer");
		String name = httpRequest.getParameter("name");
		String dateOfBirth = httpRequest.getParameter("dateofbirth");
		String streetName = httpRequest.getParameter("streetname");
		int houseNo = Integer.parseInt(httpRequest.getParameter("houseno"));
		int zipcode = Integer.parseInt(httpRequest.getParameter("zipcode"));

		Login log = new Login(username, password, securityQuestion, securityAnswer);
		Address address = new Address(streetName, houseNo, zipcode);
		Customer customer = new Customer(name, dateOfBirth, address, log);

		CustomerDao dao = new CustomerDao();
		dao.addCustomer(customer);
		
		return new ModelAndView("index.jsp");
		
	}

	@RequestMapping(value = "/passwordrecovery.html")
	public ModelAndView passwordrecovery() {

		return new ModelAndView("forgotpassword.jsp");
	}

}