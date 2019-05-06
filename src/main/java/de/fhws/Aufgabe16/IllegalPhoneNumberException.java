package de.fhws.Aufgabe16;

public class IllegalPhoneNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalPhoneNumberException() {
		super();
	}

	public IllegalPhoneNumberException(String msg) {
		super(msg);
	}
}
