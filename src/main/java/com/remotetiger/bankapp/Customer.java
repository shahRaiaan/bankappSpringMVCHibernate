package com.remotetiger.bankapp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractCustomer {

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
	private Login login;

	public Customer() {

	}

	public Customer(String name, String dateofbirth, Address address, Login login) {
		super(name, dateofbirth);
		this.address = address;
		this.login = login;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [address=");
		if (address != null) {
			builder.append(address.toString());
		}
		builder.append(", login=");
		if (login != null) {
			builder.append(login.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
