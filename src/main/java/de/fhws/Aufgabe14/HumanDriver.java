package de.fhws.Aufgabe14;

public class HumanDriver extends Driver{

	@Override
	public Decision decite(Danger danger) {
		if (Math.random() * 4 <= 1) {
			return Decision.DRAW;
		} else {
			return super.decite(danger);			
		}
	}
}
