package de.fhws.Aufgabe14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stack.Stack;

class StackTest {

	@Test
	void pushTest() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		
		assertTrue((int) stack.get(0) == 2);
		assertTrue((int) stack.get(1) == 1);
	}
	
	@Test
	void popTest() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(8);
		
		assertTrue((int) stack.pop() == 8);
		assertTrue((int) stack.get(0) == 2);
		assertTrue((int) stack.get(1) == 1);

		try {
			stack.get(3);
			fail();
		} catch(IndexOutOfBoundsException e) {
			
		}
			
	}

}
