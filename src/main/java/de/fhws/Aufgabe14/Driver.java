package de.fhws.Aufgabe14;

public class Driver implements DriverInterface{
	public Decision decite(Danger danger) {
		switch(danger) {
			case LEFT: return Decision.RIGHT;
			case RIGHT: return Decision.LEFT;
			case FRONT: return Decision.BRAKE;
			default: return Decision.DRAW;
		}
	}
}
