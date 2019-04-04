package de.fhws.Aufgabe13;

public class MultiQuiz extends Quiz{
	String[] answers;
	MultiQuizAnswers answer;
	final static String EX_TOO_MANY_ANSWERS = ("Bitte nur vier Antwortmöglichkeiten bereitstellen");
	
	public MultiQuiz(String question, String[] answers, MultiQuizAnswers answer) {
		super(question);
		
		if (answers.length > MultiQuizAnswers.values().length) throw new RuntimeException(EX_TOO_MANY_ANSWERS);
		
		this.answers = answers;
		this.answer = answer;
	}
	
	@Override
	public void askQuestion() {
		System.out.println("Fragentext:");
		System.out.println(this.question);
		System.out.println("\nAntwortmöglichkeiten:");
		
		for (int i = 0; i < answers.length; i++) {
			String a = MultiQuizAnswers.values()[i].toString();
			System.out.println(a + ":" + answers[i]);
		}
	}
	
	@Override
	public boolean checkAnswer(String quess) {
		return answer.toString().equals(quess);
	}
}
