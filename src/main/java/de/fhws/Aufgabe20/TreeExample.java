package de.fhws.Aufgabe20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeExample {
	public static void main(String[] args) {
		String[] wordList = {"Bienenschwarm", "Buch", "Bibel",
				"Beige", "Barriere", "Bein", "Beil", "Christ", "Christian",
				"Carmen"};
		
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() { // man benötigt keine Extra Klasse, kann schnell implementiert werden
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() < s2.length() ? -1 : 1;
				}
			}			
		});
		
		TreeSet<String> set2 = new TreeSet<>(new StringComparator()); //Übersichtilicher, wiederverwendbar
		set2.addAll(Arrays.asList(wordList));
		set.addAll(Arrays.asList(wordList));
		
		System.out.println(set);
		System.out.println(set2);		
	}
}
