package de.fhws.Aufgabe18;

public class Student {
	String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
