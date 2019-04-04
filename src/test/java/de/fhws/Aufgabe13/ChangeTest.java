package de.fhws.Aufgabe13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChangeTest {

	@Test
	void changeTest() {
		EnhancedChangeCalculator calc = new EnhancedChangeCalculator();
		
		// 1.70 Euro
		int[] case1 = {0, 0, 0, 0, 1, 1, 1, 0};
		
		// 3.88 Euro
		int[] case2 = {1, 1, 1, 1, 1, 1, 1, 1};

		// 5.09 Euro
		int[] case3 = {0, 2, 1, 0, 0, 0, 1, 2};
		
		assertArrayEquals(case1, calc.getChange(1, 70));
		assertArrayEquals(case2, calc.getChange(3, 88));
		assertArrayEquals(case3, calc.getChange(5, 9));
	}

}
