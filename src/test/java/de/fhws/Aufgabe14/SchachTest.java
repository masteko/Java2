package de.fhws.Aufgabe14;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import schach.Brett;
import schach.LaeuferImpl;

class SchachTest {
	
	@Test
	void laeferImplTest() {
		// 		1	2	3	4	5	6	7	8
		// 1	-	-	X	-	-	-	-	-
		// 2	-	X	-	X	-	-	-	-
		// 3	X	-	-	-	X	-	-	-
		// 4	-	-	-	-	-	X	-	-
		// 5	-	-	-	-	-	-	X	-
		// 6	-	-	-	-	-	-	-	X
		// 7	-	-	-	-	-	-	-	-
		// 8	-	-	-	-	-	-	-	-
		Brett allowedMoves = new Brett();
		allowedMoves.markiereFeld(3, 1);
		allowedMoves.markiereFeld(2, 2);
		allowedMoves.markiereFeld(1, 3);
		allowedMoves.markiereFeld(4, 2);
		allowedMoves.markiereFeld(5, 3);
		allowedMoves.markiereFeld(6, 4);
		allowedMoves.markiereFeld(7, 5);
		allowedMoves.markiereFeld(8, 6);

		LaeuferImpl laeuferImpl = new LaeuferImpl(3, 1);
		Brett moves = laeuferImpl.gibErlaubteFelder();
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				assertTrue(allowedMoves.gibFeld(i, j) == moves.gibFeld(i, j));
			}
		}

	}

	@Test
	void kombiniereTest() {
		Brett b1 = new Brett();
		b1.markiereFeld(3, 2);
		b1.markiereFeld(1, 8);
		b1.markiereFeld(6, 2);
		b1.markiereFeld(5, 5);
		
		Brett b2 = new Brett();
		b2.markiereFeld(3, 2);
		b2.markiereFeld(1, 4);
		b2.markiereFeld(8, 8);
		b2.markiereFeld(8, 1);
		
		Brett komb = b2.kombiniere(b1);
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (i == 3 && j == 2) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 1 && j == 8) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 6 && j == 2) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 5 && j == 5) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 1 && j == 4) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 8 && j == 8) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				if (i == 8 && j == 1) {
					assertTrue(komb.gibFeld(i, j));
					continue;
				}
				assertFalse(komb.gibFeld(i, j));
			}
		}
	}

}
