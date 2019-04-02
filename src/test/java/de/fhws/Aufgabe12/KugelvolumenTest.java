package de.fhws.Aufgabe12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.fhws.Aufgabe12.Kugelvolumen;

class KugelvolumenTest {

	@Test
	void kugelvolumenTest() {
		assertEquals(0, Kugelvolumen.berechneKugelvolumen(0), 0.001);
		assertEquals(4.188, Kugelvolumen.berechneKugelvolumen(1), 0.001);
		assertEquals(523.598, Kugelvolumen.berechneKugelvolumen(5), 0.001);
		
		try {
			Kugelvolumen.berechneKugelvolumen(-1);
			fail();			
		} catch (RuntimeException e) {
			if (!e.getMessage().equals("Keine negativen Zahlen")) fail();
		}
	}

}
