package de.fhws.Aufgabe12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonAdresseTest {

	@Test
	void vornamenTest() {
		Person p1 = new Person("Arthur", "Dent", null);
		
		try {
			Person p2 = new Person("arthur", "Dent", null);
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Vorname muss mit Großbuchstaben beginnen")) fail();
		}	
	}
	
	@Test
	void strassenTest() {
		
		try {
			Adresse a2 = new Adresse("michael..", "5c", "97421", "Schweft");
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Straße und Ort müssen mit Großbuchstaben beginnen")) fail();
		}	
	}
	
	@Test
	void ortTest() {	
		try {
			Adresse a2 = new Adresse("Michael..", "5c", "97421", "schweft");
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Straße und Ort müssen mit Großbuchstaben beginnen")) fail();
		}
	}
	
	@Test
	void hausnummerTest() {
		try {
			Adresse a1 = new Adresse("Michael..", "5c", "97421", "Schweft");			
		} catch (Exception e) {
			fail("fehler");
		}
		
		try {
			Adresse a2 = new Adresse("Michael..", "c5", "97421", "Schweft");
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Hausnummer muss mit einer Zahl beginnen")) fail();
		}
	}

}
