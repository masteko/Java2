package de.fhws.Aufgabe21;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Aufgabe1 {
	public static void main(String[] args) {
		List<Mannschaft> mannschaften = Mannschaft.createTabelle();
		
		Predicate<Mannschaft> filter = Aufgabe1::filterByScore;
		
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
			.ifPresent(System.out::println);
		
		System.out.println("------------------------------------------");
		
		List<Mannschaft> liste = mannschaften
			.stream()
			.filter(filter)
			.collect(Collectors.toList());
		
		System.out.println(liste);
	}
	
	private static boolean filterByScore(Mannschaft m) {
		return m.punkte > 50;
	}
}
