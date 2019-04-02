package de.fhws.Aufgabe13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testCreatePersonArrayLenght() {
		Person p[] = Person.createPersonArray();
		assertTrue(p.length == 100);
	}
	
	@Test
	void testCreatePersonArray() {
		Person p[] = Person.createPersonArray();
		Person prev = p[0];
		
		for (int i = 1; i < p.length; i++) {
			if (prev instanceof Student) {
				assertTrue(p[i] instanceof Professor);				
			} else {
				assertTrue(p[i] instanceof Student);
			}
			prev = p[i];
		}
	}
}
