package de.fhws.Aufgabe12;

public class Adresse {
	String strasse;
	String hausnummer;
	String plz;
	String ort;
	
	public Adresse(String strasse, String hausnummer, String plz, String ort) {
		if (Character.isLowerCase(strasse.charAt(0)) || Character.isLowerCase(ort.charAt(0))) throw new RuntimeException("Straße und Ort müssen mit Großbuchstaben beginnen");
		if (!hausnummer.startsWith("\\[0-9]")) throw new RuntimeException("Hausnummer muss mit einer Zahl beginnen");

		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}
}
