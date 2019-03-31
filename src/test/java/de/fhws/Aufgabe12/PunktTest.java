package de.fhws.Aufgabe12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PunktTest {

	@Test
	void test() {
		try {
			Punkt p2 = new Punkt();
			p2.verschiebePunkt(1920, 1080);
		} catch (Exception e) {
			fail();
		}
		
		try {
			Punkt p1 = new Punkt();
			p1.verschiebePunkt(-1, 4);
			p1.verschiebePunkt(5, -3);
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Keine negativen Zahlen")) fail();
		}
		
		try {
			Punkt p1 = new Punkt();
			p1.verschiebePunkt(1921, 4);
			p1.verschiebePunkt(1920, 1081);
			fail();
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Zahl außerhab des Wertebereichs")) fail();
		}
	}

}
