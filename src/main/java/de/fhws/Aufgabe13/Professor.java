package de.fhws.Aufgabe13;

public class Professor extends Person{

	@Override
	void gibTaetigkeitAus() {
		System.out.println("Der Professor lehrt.");	
	}
	
	void lehre() {
		System.out.println("Ich lehre");
	}
}
