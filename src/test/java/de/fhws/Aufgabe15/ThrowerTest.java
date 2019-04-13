package de.fhws.Aufgabe15;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class ThrowerTest {

	@Test
	void arrayIndexOutOfBoundsException() {
		try {
			Thrower.arrayIndexOutOfBoundsException();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}
	}
	
	@Test
	void numberFormatException() {
		try {
			Thrower.numberFormatException();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NumberFormatException);
		}
	}
	
	@Test
	void nullPointerException() {
		try {
			Thrower.nullPointerException(null);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}
	
	@Test
	void outOfMemoryError() {
		try {
			Thrower.outOfMemoryError();
			fail();
		} catch (Error e) {
			assertTrue(e instanceof OutOfMemoryError);
		}
	}
	
	@Test
	void fileNotFoundException() {
		try {
			Thrower.fileNotFoundException();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof FileNotFoundException);
		}
	}
	
	@Test
	void arithmeticException() {
		try {
			Thrower.arithmeticException();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof ArithmeticException);
		}
	}

}
