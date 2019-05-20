package de.fhws.Aufgabe18;

import java.util.HashSet;
import java.util.Set;

public class MauMau {
	// a) Karte, evtl. Kartentyp, Deck, Spieler, Kartenhand, Züge, Board
	// b) Eine Kollektion oder Set
	
	public static void main(String[] args) {
		int count = 0;
		Set<String> hand = new HashSet<String>();
		String[] karten = { "Kreuz Bube", "Pik Ass", "Herz Dame", "Karo 10", "Karo Ass", "Pik Bube", "Pik 7" };
		
		while (hand.size() < 5) {
			hand.add(karten[(int) (Math.random() * karten.length)]);
			count++;
		}
		
		System.out.println(count);
		
		for (String s : hand) {
			System.out.println(s);
		}
	}
}
