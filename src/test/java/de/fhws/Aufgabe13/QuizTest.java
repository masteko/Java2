package de.fhws.Aufgabe13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuizTest {
	MultiQuizAnswers multiAnswer = MultiQuizAnswers.B;
	String textAnswer = "Darum";

	@Test
	void MultipleQuizWithTooManyAnswers() {
		String[] answers = {"3", "4", "0", "5", "1"};
		try {
			new MultiQuiz("Should I throw an exception?", answers, multiAnswer);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().equals(MultiQuiz.EX_TOO_MANY_ANSWERS));
		}
	}
	
	@Test
	void MultipleQuizHasAskQuestionMethod() {
		createMultiQuiz().askQuestion();
	}
	
	@Test
	void MultipleQuizValidationMethod() {
		Quiz multi = createMultiQuiz();

		for (int i = 0; i < MultiQuizAnswers.values().length; i++) {
			if (MultiQuizAnswers.values()[i] == multiAnswer) {
				assertTrue(multi.checkAnswer(multiAnswer.toString()));				
			} else {
				assertFalse(multi.checkAnswer(MultiQuizAnswers.values()[i].toString()));
			}
		}
	}
	
	@Test
	void TextQuizHasAskQuestionMethod() {
		createTextQuiz().askQuestion();
	}

	@Test
	void TextQuizValidationnMethod() {
		Quiz text = createTextQuiz();
		
		assertFalse(text.checkAnswer("deshalb"));
		assertFalse(text.checkAnswer("darum"));
		assertFalse(text.checkAnswer("wieso"));
		assertFalse(text.checkAnswer("daso"));
		assertTrue(text.checkAnswer(textAnswer));
	}
	
	Quiz createMultiQuiz() {
		String[] answers = {"3", "4", "0"};
		Quiz multiQuiz = new MultiQuiz("Wie viele Ecken hat ein Viereck?", answers, multiAnswer);
		
		return multiQuiz;
	}
	
	Quiz createTextQuiz() {
		return new TextQuiz("Warum ist die Banane krum?", textAnswer);
	}
}
