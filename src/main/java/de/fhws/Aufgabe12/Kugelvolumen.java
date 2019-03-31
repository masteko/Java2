package de.fhws.Aufgabe12;

public class Kugelvolumen {
	public static double berechneKugelvolumen(double radius) {
		if (radius >= 0) {
			return 4.0/3 * Math.PI * radius * radius * radius;			
		} else {
			throw new RuntimeException("Keine negativen Zahlen");
		}
	}
}
