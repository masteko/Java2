package de.fhws.Aufgabe21;

import java.util.List;

public class Aufgabe1 {
	public static void main(String[] args) {
		List<Mannschaft> mannschaften = Mannschaft.createTabelle();
		mannschaften
			.stream()
			.filter(m -> m.punkte > 50)
			.forEach(m -> System.out.println(m));
		
		System.out.println("------------------------------------------");
		
		mannschaften
			.stream()
			.sorted()
			.filter(m -> m.name.startsWith("F"))
			.forEach(m -> System.out.println(m));
		
		System.out.println("------------------------------------------");
		
		mannschaften
			.stream()
			.max((m1, m2) -> m1.gegentore - m2.gegentore)
			.ifPresent(m -> System.out.println(m));
	}
}
