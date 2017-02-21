package com.remotetiger.bankapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "street_name")
	private String streetname;
	@Column(name = "house_no")
	private int houseno;
	@Column(name = "zipcode")
	private int zipcode;

	public Address() {

	}

	public Address(String streetname, int houseno, int zipcode) {
		this.streetname = streetname;
		this.houseno = houseno;
		this.zipcode = zipcode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", streetname=");
		builder.append(streetname);
		builder.append(", houseno=");
		builder.append(houseno);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append("]");
		return builder.toString();
	}
}
