package de.fhws.SS17;

import java.util.Collection;

public class Aufgabe2 {
	public static void main(String[] args) {
		Wort und = new Wort("und");
		WortVorkommen woerter = new WortVorkommen();
		woerter.einfuegen(und, new Position(3, 8));
		woerter.einfuegen(und, new Position(1, 3));
		woerter.einfuegen(und, new Position(3, 7));
		
		Position letztePosition = woerter.holeLetztePosition(und);
		Collection<Position> allePositionen = woerter.holeAlle(und);
		int anzahlVorkommen = woerter.anzahlVorkommen(und);
		
		System.out.println("letzte Position: " + letztePosition);
		System.out.println("alle Positionen: " + allePositionen);
		System.out.println("anzahl vorkommen: " + anzahlVorkommen);
	}
}
