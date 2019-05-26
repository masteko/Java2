package de.fhws.Aufgabe18;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Deck {
	List<Card> cards = new ArrayList<>();
	
	public Deck() {
		for (Color c : Color.values()) {
			for (Value v : Value.values()) {
				cards.add(new Card(v, c));
			}
		}
	}
	
	@Override
	public String toString() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		ps.println("Das Deck besteht aus folgenden " + cards.size() + " Karten");
		for (Card c : cards) {
			ps.println(c);
		}
		ps.flush();
		return baos.toString();
	}
}
