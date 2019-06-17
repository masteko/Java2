package de.fhws.Aufgabe22;

import java.util.List;
import java.util.stream.Collectors;

public class BBruder {
	String name;
	int bankDrueckenGewicht;
	int knieBeugenGewicht;

	public BBruder(String name, int bankDrueckenGewicht, int knieBeugenGewicht) {
		this.name = name;
		this.bankDrueckenGewicht = bankDrueckenGewicht;
		this.knieBeugenGewicht = knieBeugenGewicht;
	}

	@Override
	public String toString() {
		return String.format("Name: %s, Bankdrücken: %dkg, Kniebeugen %dkg", name, bankDrueckenGewicht,
				knieBeugenGewicht);
	}

	public static void main(String[] args) {
		List<BBruder> bBrothers = List.of(
				new BBruder("Burt", 238, 311),
				new BBruder("Bronski", 200, 274),
				new BBruder("Bruno", 236, 328));
		
		bBrothers.stream()
			.map(b -> b.name)
			.reduce((name1, name2) -> name1 + ", " + name2)
			.ifPresent(System.out::println);
		
		bBrothers.stream()
			.map(b -> b.bankDrueckenGewicht)
			.reduce((b1, b2) -> b1 + b2)
			.ifPresent(v -> System.out.println(v / bBrothers.size()));
	}
}
