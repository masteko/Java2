package de.fhws.Aufgabe16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Aufgabe1 {
	public static void main(String[] args) {
		try {
			splitStudiengaenge("MatrNr.txt");			
		} catch (MatrikelNummerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void splitStudiengaenge(String filename) throws MatrikelNummerException {
		try(BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter winf = new BufferedWriter(new FileWriter("WInfNr.txt"));
			BufferedWriter inf = new BufferedWriter(new FileWriter("InfNr.txt"));
			BufferedWriter ec = new BufferedWriter(new FileWriter("ECNr.txt"));) {
			
			String line;
			
			do {
				line = br.readLine();
				System.out.println(line);
				if (line == null) break;
				
				int number = Integer.valueOf(line);
				
				if (number >= 5000000 && number < 5100000) {
					winf.write(line + "\n");
				} else if(number >= 5100000 && number < 5200000) {
					inf.write(line + "\n");
				} else if (number >= 6100000 && number < 6200000){
					ec.write(line + "\n");
				} else {
					throw new MatrikelNummerException("Matrikelnummer falsch " + line);
				}
				
			} while(line != null);
			
		} catch (IOException e) {
			throw new MatrikelNummerException("File not found");
		}
	}
}
