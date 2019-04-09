package de.fhws.Aufgabe13;

import java.util.Scanner;

public abstract class Quiz {
	String question;
	
	public Quiz(String question) {
		this.question = question;
	}
	
	public abstract void askQuestion();
	public abstract boolean checkAnswer(String quess);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Quiz[] deck = new Quiz[2];
		String[] answers = {"4", "2", "1", "0"};
		
		deck[0] = new TextQuiz("Wie heisst die Hauptstadt von Deutschland?", "Berlin");
		deck[1] = new MultiQuiz("Wie viele Protonen hat ein Wasserstoff-Atom?", answers, MultiQuizAnswers.C);
		
		for (int i = 0; i < deck.length; i++) {
			deck[i].askQuestion();
			boolean right = deck[i].checkAnswer(scanner.nextLine());
			System.out.println("\nDie Antwort war " + (right ? "richtig\n" : "falsch\n"));
		}
		
		scanner.close();
	}
}
