package de.fhws.SS17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IBANTest {

	@Test
	void ibanTest() {
		assertThrows(FalscheIBANException.class, () -> Aufgabe1.ibanCheck("DE2130120400000BYI15422"));
	}

}
