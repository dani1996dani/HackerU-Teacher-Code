package com.company;

public class Person {

	private String firstName, lastName;
	private City city;
	private String email;

	public static final int KFAR_SABA = 123;

	public Person(String firstName, String lastName, City city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
