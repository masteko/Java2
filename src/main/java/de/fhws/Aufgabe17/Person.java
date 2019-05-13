package de.fhws.Aufgabe17;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3075214753311122502L;
	
	String nachname;
	String name;
	String telefon;
	
	public Person(String nachname, String name, String telefon) {
		this.nachname = nachname;
		this.name = name;
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.nachname;
	}
}
