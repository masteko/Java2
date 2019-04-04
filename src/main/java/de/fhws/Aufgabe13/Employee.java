package de.fhws.Aufgabe13;

import java.util.UUID;

public class Employee {
	private String firstname;
	private String surename;
	private UUID ident;
	private double salary;
	private double salaryFactor = 1.0d;
	private String birthdate;
	
	public Employee() {
		this.ident = UUID.randomUUID();		
	}
	
	public Employee(String firstname, String surename, double salary, String birthdate) {
		this();
		this.firstname = firstname;
		this.surename = surename;
		this.salary = salary;
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public UUID getIdent() {
		return ident;
	}

	public void setIdent(UUID ident) {
		this.ident = ident;
	}

	public double getSalary() {
		return salary * this.salaryFactor;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalaryFactor() {
		return salaryFactor;
	}

	public void setSalaryFactor(double salaryFactor) {
		this.salaryFactor = salaryFactor;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
}
