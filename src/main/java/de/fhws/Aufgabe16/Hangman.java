package de.fhws.Aufgabe16;

public class Hangman {
    static String[] words = { "Programmiersprache", "Studium", "Hochhaus", "Schifffahrt",
            "Hörsaal", "Wörter", "ausdenken"};
    
    int tries = 0;
    int maxTries = 20;
    String word;
    char[] foundChars;
    
    public Hangman() {
    	word = words[(int) (Math.random() * words.length)].toUpperCase();
    	foundChars = new char[word.length()];
    	
    	for (int i = 0; i < foundChars.length; i++) {
    		foundChars[i] = '_';
    	}
    }
    
    public Hangman(int maxTries) {
    	this();
    	this.maxTries = maxTries;
    }
    
    public boolean guess(char guess) throws DuplicateInputException, GameOverException {
    	char[] wordArr = this.word.toCharArray();
    	char c = Character.toUpperCase(guess);
  
    	for (int i = 0; i < wordArr.length; i++) {
    		if (c == wordArr[i]) {
    			if (this.foundChars[i] != '_') throw new DuplicateInputException();
    			this.foundChars[i] = c;
    		}
    	}
    	
    	this.tries++;
    	
    	if (this.tries == this.maxTries && String.valueOf(foundChars).contains("_")) {
    		throw new GameOverException();
    	}
    	
    	return !String.valueOf(foundChars).contains("_");
    }
    
    @Override
    public String toString() {
    	String result = "";
 
    	for (int i = 0; i < this.foundChars.length; i++) {
    		result += this.foundChars[i] + " ";
    	}
    	
    	return result.substring(0, result.length() -1);
    }
}
