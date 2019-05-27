package de.fhws.Aufgabe19;

public class Question {
	String text;
	
	public Question(String text) {
		this.text = text;
	}
	
	public static Question toQuestion(String line) {
		return new Question(line);
	}
}
