package de.fhws.Aufgabe12;

public class Person {
	String vorname;
	String nachname;
	Adresse adresse;
	
	public Person(String vorname, String nachname, Adresse adresse) {
		if (Character.isLowerCase(vorname.charAt(0))) throw new RuntimeException("Vorname muss mit Großbuchstaben beginnen");
		
		this.adresse = adresse;
		this.vorname = vorname;
		this.nachname = nachname;
	}
}
