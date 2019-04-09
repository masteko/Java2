package de.fhws.Aufgabe14;

public class Driver implements DriverInterface{
	public Decision decite(Danger danger) {
		switch(danger) {
			case DANGER_LEFT: return Decision.RIGHT;
			case DANGER_RIGHT: return Decision.LEFT;
			case DANGER_FRONT: return Decision.BRAKE;
			default: return Decision.DRAW;
		}
	}
}
