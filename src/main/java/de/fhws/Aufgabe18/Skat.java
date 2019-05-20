package de.fhws.Aufgabe18;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Skat {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Hand hand = new Hand(10, deck, "test");
		Hand hand2 = new Hand(10, deck, "test");
		Collections.sort(hand.cards);
		Collections.sort(hand2.cards);
		System.out.println(hand);
		System.out.println(hand2);
	}

}
