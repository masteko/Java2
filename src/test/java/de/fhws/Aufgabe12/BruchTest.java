package de.fhws.Aufgabe12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.fhws.Aufgabe12.Bruch;

class BruchTest {

	@Test
	void test() {
		try {
			Bruch bruch = new Bruch(1,4);
		} catch (Exception e) {
			fail();
		}
		try {
			Bruch test = new Bruch(1, 0);
			fail();
		} catch (ArithmeticException e) {
			if (!e.getMessage().equals("Nenner darf nicht 0 sein")) fail();
		}
	}

}
