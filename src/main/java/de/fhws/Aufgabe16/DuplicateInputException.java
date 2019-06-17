package de.fhws.Aufgabe16;

public class DuplicateInputException extends Exception {
	public DuplicateInputException() {
		super("asdf");
	}
	
	public static void main(String[] args) {
		try {
			Test.test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Test {
	public static void test() throws DuplicateInputException {
		throw new DuplicateInputException();
	}
}
