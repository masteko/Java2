package de.fhws.ZErsterTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSign {

	@Test
	void testSignOperator() {
		assertTrue(-1==Sign.sign(-5));
		assertTrue(1==Sign.sign(5));
		assertTrue(0==Sign.sign(0));
	}

}
