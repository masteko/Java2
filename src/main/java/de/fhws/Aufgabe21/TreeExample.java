package de.fhws.Aufgabe21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeExample {
	public static void main(String[] args) {
		String[] wordList = {"Bienenschwarm", "Buch", "Bibel",
				"Beige", "Barriere", "Bein", "Beil", "Christ", "Christian",
				"Carmen"};
		
		TreeSet<String> set = new TreeSet<>((s1, s2) -> { // man benötigt keine Extra Klasse, kann schnell implementiert werden
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			} else {
				return s1.length() - s2.length();
			}
		});
		
		set.addAll(Arrays.asList(wordList));
		
		System.out.println(set);		
	}
}
