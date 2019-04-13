package de.fhws.Aufgabe15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Thrower {

	public static void main(String[] args) {
		try {
			numberFormatException();
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException triggered");
		}
		
		try {			
			arrayIndexOutOfBoundsException();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException triggered");
		}
		
		try {			
			nullPointerException(null);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException triggered");
		}
		
		try {
			outOfMemoryError();
		} catch (OutOfMemoryError e) {
			System.out.println("OutOfMemoryError triggered");
		}
		
		try {
			fileNotFoundException();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException triggered");
		}

		try {
			arithmeticException();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException triggered");
		}
	}
	
	static void numberFormatException() {
		System.out.println(Integer.valueOf("3sd"));		
	}

	static void arrayIndexOutOfBoundsException() {
		int[] arr = new int[2];
		System.out.println(arr[arr.length]);
	}
	
	static void nullPointerException(Scanner s) {
		s.nextLine();
	}
	
	static void outOfMemoryError() {
		Object[] obj = new Object[Integer.MAX_VALUE];
	}
	
	static void fileNotFoundException() throws FileNotFoundException {
		InputStream in = new FileInputStream("asdf");
	}
	
	static int arithmeticException() {
		return 8 / 0;
	}
}
