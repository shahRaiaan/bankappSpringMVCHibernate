package com.remotetiger.bankapp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
class AbstractCustomer {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "dateofbirth")
	private String dateofbirth;

	public AbstractCustomer() {

	}

	public AbstractCustomer(String name, String dateofbirth) {
		this.name = name;
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractCustomer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dateofbirth=");
		builder.append(dateofbirth);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
