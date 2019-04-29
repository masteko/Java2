package de.fhws.Aufgabe14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrivingTest {
	RobotDriver r;

	@Test
	void robotDecisionTest() {
		RobotDriver r = new RobotDriver();
		
		assertTrue(Decision.LEFT.equals(r.decite(Danger.RIGHT)));
		assertFalse(Decision.RIGHT.equals(r.decite(Danger.RIGHT)));
		assertFalse(Decision.BRAKE.equals(r.decite(Danger.RIGHT)));
		assertFalse(Decision.DRAW.equals(r.decite(Danger.RIGHT)));
		
		assertTrue(Decision.RIGHT.equals(r.decite(Danger.LEFT)));
		assertFalse(Decision.LEFT.equals(r.decite(Danger.LEFT)));
		assertFalse(Decision.BRAKE.equals(r.decite(Danger.LEFT)));
		assertFalse(Decision.DRAW.equals(r.decite(Danger.LEFT)));

		assertTrue(Decision.BRAKE.equals(r.decite(Danger.FRONT)));
		assertFalse(Decision.RIGHT.equals(r.decite(Danger.FRONT)));
		assertFalse(Decision.DRAW.equals(r.decite(Danger.FRONT)));
		assertFalse(Decision.LEFT.equals(r.decite(Danger.FRONT)));
	}
	
	@Test
	void humanDecisionTest() {
		float failurePercentage = getFailurePercentage(new HumanDriver());
		assertEquals(25, failurePercentage, 0.1);
	}
	
	@Test
	void cyborgTest() {	
		float failurePercentage = getFailurePercentage(new Cyborg());
		assertEquals(12.5, failurePercentage, 0.1);
	}
	
	float getFailurePercentage(DriverInterface h) {
		int iterations = 1000000;
		int failures = 0;
		int randomNumber;

		for (int i = 0; i < iterations; i++) {
			randomNumber = (int) Math.random() * Danger.values().length;
			Danger d = Danger.values()[randomNumber];
			Decision decision = h.decite(d);
			if (!getByDanger(d).equals(decision)) {
				failures++;
				
				if (failures == 0) assertTrue(Decision.DRAW.equals(decision));
			}
		}
		
		return failures / (float) iterations * 100f;
	}
	
	Decision getByDanger(Danger danger) {
		if (r == null) r = new RobotDriver();
		return r.decite(danger);
	}

}
