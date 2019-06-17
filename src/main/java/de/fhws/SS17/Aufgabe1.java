package de.fhws.SS17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import com.sun.tools.javac.util.List;

public class Aufgabe1 {
	public static boolean ibanCheck(String iban) throws FalscheIBANException {
		if (iban.substring(0,2).equals("DE") && iban.substring(2).length() == 20)
			return true;
		else throw new FalscheIBANException(iban + " ist keine gültige IBAN");
	}
	
	public static void main(String[] args) {
		try {
			ibanCheck("DE2130120400000BYI1522");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] f = { "korrekteIbans.txt", "fehlerhafteIbans.txt" };
		
		dateienTest(f);
	}
	
	public static void dateienTest(String[] namen) {
		for (String fname : namen) {
			try {
				ibansAuslesen(fname);				
			} catch (Exception e) {
				System.out.println(fname + " enthaelt fehlerhafte IBANs");
			}
		}
	}
	
	public static void ibansAuslesen(String fname) throws FalscheIBANException{
		
		try (BufferedReader bf = new BufferedReader(new FileReader(fname))) {
			String line = bf.readLine();
			
			while(line != null) {
				ibanCheck(line);
				line = bf.readLine();
			}
			
			System.out.println("alle Ibans sind korrekt");
			
		} catch (IOException e){
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
