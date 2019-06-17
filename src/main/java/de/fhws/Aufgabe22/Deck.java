package de.fhws.Aufgabe22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
	List<Karte> karten;
	
	public void erzeugeDeck() {
		karten = new ArrayList<>();
		Arrays.asList(Wert.values()).stream()
			.forEach(w -> {
				Arrays.asList(Farbe.values()).stream()
					.forEach(f -> karten.add(new Karte(f, w)));
			});		
	}
	
	@Override
	public String toString() {
		return karten.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", "));
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		
		d.erzeugeDeck();
		System.out.println(d); 
	}
}
