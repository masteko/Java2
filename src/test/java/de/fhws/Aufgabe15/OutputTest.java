package de.fhws.Aufgabe15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputTest {
	
	@Test
	void validArguments() {
		byte[] arr = new byte[20];
		
		Output.write(arr, 0, 20);
		Output.write(arr, 1, 19);
		Output.write(arr, 19, 1);		
	}

	@Test
	void lengthExceededTest() {
		byte[] arr = new byte[20];
		
		try {
			Output.write(arr, 20, 1);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().equals(Output.ERROR_LENGTH_EXCEEDED));
		}
	}
	
	@Test
	void lengthEmptyTest() {
		byte[] arr = new byte[20];
		
		try {
			Output.write(arr, 19, 2);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().equals(Output.ERROR_LENGTH_EMPTY));
		}
	}
	
	@Test
	void emptyArrayTest() {
		byte[] arr = new byte[0];
		
		try {
			Output.write(arr, 21, 1);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().equals(Output.ERROR_ARRAY_EMPTY));
		}
	}

}
