package de.fhws.SS17;

public class FalscheIBANException extends Exception {

	public FalscheIBANException() {
		super("Fehler");
	}
	
	public FalscheIBANException(String msg) {
		super(msg);
	}
}
