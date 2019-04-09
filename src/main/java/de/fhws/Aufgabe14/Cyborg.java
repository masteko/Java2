package de.fhws.Aufgabe14;

public class Cyborg implements DriverInterface {
	Human humanDriver;;
	Robot robotDriver;

	public Cyborg() {
		humanDriver = new Human();
		robotDriver = new Robot();
	}

	@Override
	public Decision decite(Danger danger) {
		Decision humanDecision = humanDriver.decite(danger);
		Decision robotDecision = robotDriver.decite(danger);
		
		if (humanDecision.equals(robotDecision)) {
			return humanDecision;
		} else {
			return (Math.random() >= 0.5) ? humanDecision : robotDecision;
		}
	}
}
