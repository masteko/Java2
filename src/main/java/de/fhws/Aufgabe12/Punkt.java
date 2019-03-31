package de.fhws.Aufgabe12;

public class Punkt {
	int x;
	int y;
	
	public void verschiebePunkt(int zielX, int zielY) {
		if (zielX < 0 || zielY < 0) throw new RuntimeException("Keine negativen Zahlen");
		if (zielX > 1920 || zielY > 1080) throw new RuntimeException("Zahl außerhab des Wertebereichs");
		
		x = zielX;
		y = zielY;
	}
}
