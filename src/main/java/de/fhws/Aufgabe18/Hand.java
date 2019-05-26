package de.fhws.Aufgabe18;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> cards = new ArrayList<>();
	String name;
	
	public Hand(int cardAmount, String name) {
		Deck deck = new Deck();
		this.name = name;

		while (cards.size() < cardAmount) {
			Card c = (Card) deck.cards.toArray()[(int) (Math.random() * deck.cards.size())];
			if (!cards.contains(c)) {
				cards.add(c);
			}
		}
	}
	
	public Hand(int cardAmount, Deck deck, String name) {
		this.name = name;

		while (cards.size() < cardAmount) {
			Card c = (Card) deck.cards.toArray()[(int) (Math.random() * deck.cards.size())];

			cards.add(c);
			deck.cards.remove(c);
		}
	}
	
	@Override
	public String toString() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		ps.println("Die Hand " + this.name + " besteht aus folgenden Karten");
		for (Card c : cards) {
			ps.println(c);
		}
		ps.flush();
		return baos.toString();
	}
}
