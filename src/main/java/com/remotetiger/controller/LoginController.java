package com.remotetiger.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.remotetiger.bankapp.Customer;
import com.remotetiger.dao.CustomerDao;
import com.remotetiger.dao.LoginDao;

@Controller
public class LoginController {
	@Autowired
	private HttpServletRequest httpRequest;

	@RequestMapping(value = "/")
	public ModelAndView welcomePage() {

		return new ModelAndView("index.jsp");
	}

	@RequestMapping(value = "/signin.html")
	public ModelAndView accountdetail() {
		LoginDao dao = new LoginDao();
		CustomerDao cdao = new CustomerDao();

		String username = httpRequest.getParameter("getUserName");
		String password = httpRequest.getParameter("getUserPassword");

		int id = dao.validate(username, password);

		if (id != -1) {

			Customer customer = cdao.getCustomerById(id);

			return new ModelAndView("accountdetail.jsp", "customer", customer);

		} else {

			return new ModelAndView("index.jsp");
		}

	}

}
