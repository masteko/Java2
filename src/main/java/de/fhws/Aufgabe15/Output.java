package de.fhws.Aufgabe15;

public class Output {
	final static String ERROR_LENGTH_EMPTY = "Length value to High";
	final static String ERROR_LENGTH_EXCEEDED = "Length value to High";
	final static String ERROR_ARRAY_EMPTY = "Empty Array";

	public static void main(String[] args) {
		
	}
	
	static void write(byte[] b, int off, int len) {
		if (b.length == 0) throw new RuntimeException(ERROR_ARRAY_EMPTY);
		if (len == 0) throw new RuntimeException(ERROR_LENGTH_EMPTY);
		if (off + len > b.length) throw new RuntimeException(ERROR_LENGTH_EXCEEDED);
	}

}
