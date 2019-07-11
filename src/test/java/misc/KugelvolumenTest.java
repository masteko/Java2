package misc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KugelvolumenTest {

	@Test
	void Kugeltest() {
		assertEquals(381.7035074, Kugelvolumen.berechneKugelvolumen(4.5), 0.0000001);
	}
	
	@Test
	void Kugeltest2() {
		Exception e = assertThrows(RuntimeException.class, () -> Kugelvolumen.berechneKugelvolumen(0));
		assertEquals("Ungueltiger Radius", e.getMessage());
		Exception f = assertThrows(RuntimeException.class, () -> Kugelvolumen.berechneKugelvolumen(2));
	}

}
