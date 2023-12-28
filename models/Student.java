package com.NorrenCloud.CloudPoc.models;

import java.sql.Date;

public class Student {
	private String firstname;
	private String lastname;
	private String department;
	private String email;
	private Date birthDate;
	private String address;

	public Student() {
		super();
	}

	public Student(String firstname, String lastname, String department, String email, Date birthDate,
			String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
	}
	public Student(String firstname, String lastname, String department, Date birthDate , String email,
			String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.birthDate = birthDate;
		this.email = email;		
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", department=" + department + ", email="
				+ email + ", birthDate=" + birthDate + ", address=" + address + "]";
	}

}
