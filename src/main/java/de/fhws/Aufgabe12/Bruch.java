package de.fhws.Aufgabe12;

public class Bruch {
	int zaehler;
	int nenner;
	
	public Bruch(int zaehler, int nenner) {
		if (nenner == 0) {
			throw new ArithmeticException("Nenner darf nicht 0 sein");
		}
		
		this.zaehler = zaehler;
		this.nenner = nenner;
		
	}
}
