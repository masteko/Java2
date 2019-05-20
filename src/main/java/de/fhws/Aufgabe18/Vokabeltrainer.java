package de.fhws.Aufgabe18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vokabeltrainer {
	Map<String, ArrayList<String>> english2German = new HashMap<>();
	String wordToGuess;

	public void addToDictionary(String englishWord, String ...germanWords) {
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(germanWords));
		english2German.put(englishWord, list);
	}

	public void createRandomWordToGuess() {
		Set<String> keySet = english2German.keySet();
		int randomIndex = (int)(Math.random()*keySet.size());
		Iterator<String> iterator = keySet.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			String word = iterator.next();
			if (i == randomIndex) {
				wordToGuess = word;
				return;
			}
			i++;
		}
	}

	public String getWordToGuess() {
		return wordToGuess;
	}
	
	public boolean guess(String guess) {
		ArrayList<String> solutions = english2German.get(wordToGuess);
		if (solutions.contains(guess))
		return true;
		return false;
	}
	
	public static void main(String[] args) {
		Vokabeltrainer guessingGame = new Vokabeltrainer();

		guessingGame.addToDictionary("to clean", "reinigen", "aufräumen");
		guessingGame.addToDictionary("to expand", "vergrößern");

		guessingGame.createRandomWordToGuess();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Was heißt \"" + guessingGame.getWordToGuess() + "\" auf Deutsch?");
		String guess = scanner.nextLine();
		boolean correct = guessingGame.guess(guess);
		if (correct)
			System.out.println("Korrekt!");
		else
			System.out.println("Leider falsch!");
		scanner.close();
	}
}
