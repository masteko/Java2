package de.fhws.Aufgabe16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneNumber {
	String inputFile;
	String outputFile;
	
	public static void main(String[] args) {
		PhoneNumber pn = new PhoneNumber("Strings.txt", "Phone.txt");
		try {
			pn.generatePhoneNumberFile();
		} catch (IllegalPhoneNumberException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PhoneNumber(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	private char generateNumber(char c) throws IllegalPhoneNumberException {
		char result;

		if (c < 'A' || c > 'Z') {
			throw new IllegalPhoneNumberException(String.valueOf(c));
		}
		
		if (c <= 'C') {
			result = '2';
		} else if (c <= 'F') {
			result = '3';
		} else if (c <= 'I') {
			result = '4';
		} else if (c <= 'L') {
			result = '5';
		} else if (c <= 'O') {
			result = '6';
		} else if (c <= 'S') {
			result = '7';
		} else if (c <= 'V') {
			result = '8';
		} else {
			result = '9';
		}
		
		return result;
	}
	
	public void generatePhoneNumberFile() throws IllegalPhoneNumberException, IOException {
		String line;
		char[] lineArr;
		char[] numArr;
		int offset = 0;

		try ( 
			FileReader r = new FileReader(this.inputFile);
			FileWriter w = new FileWriter(this.outputFile);
			BufferedReader br = new BufferedReader(r);
			BufferedWriter bw = new BufferedWriter(w);
		) {
			while ((line = br.readLine()) != null) {
				lineArr = line.toUpperCase().toCharArray();
				numArr = new char[lineArr.length];
				
				for (int i = 0; i < lineArr.length; i++) {
					try {
						numArr[i - offset] = generateNumber(lineArr[i]);				
					} catch (IllegalPhoneNumberException e) {
						offset++;
					}
				}
				bw.write(String.valueOf(numArr).trim());
				bw.newLine();
			}
		} catch (IOException e) {
			throw new IOException(e);
		}
		if (offset > 0) {
			throw new IllegalPhoneNumberException();
		}
	}
}
