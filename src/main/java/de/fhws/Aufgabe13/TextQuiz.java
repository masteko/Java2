package de.fhws.Aufgabe13;

public class TextQuiz extends Quiz{
	String answer;
	
	public TextQuiz(String question, String answer) {
		super(question);
		this.answer = answer;
	}
	
	@Override
	public void askQuestion() {
		System.out.println("Fragentext:");
		System.out.println(this.question);
		System.out.println("\nAntwort:");
	}
	
	@Override
	public boolean checkAnswer(String quess) {
		return this.answer.equals(quess);
	}
}
