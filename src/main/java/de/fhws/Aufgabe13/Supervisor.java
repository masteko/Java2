package de.fhws.Aufgabe13;

public class Supervisor extends Employee{

	public Supervisor() {
		super();	
	}
	
	public Supervisor(String firstname, String surename, double salary, String birthdate) {
		super(firstname, surename, salary, birthdate);
		super.setSalaryFactor(2);
	}
	
	public void promote(Employee employee) {
		employee.setSalaryFactor(employee.getSalaryFactor() * 1.1d);
	}
	
}
