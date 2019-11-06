package de.fhws.Aufgabe14;

public class Main {
	static DriverInterface di = (danger) -> Decision.BRAKE;
	
	public static void main(String[] args) {
		System.out.println(di.decite(Danger.FRONT));
	}
}
