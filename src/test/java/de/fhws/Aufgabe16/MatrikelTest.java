package de.fhws.Aufgabe16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class MatrikelTest {

	@Test
	void wrongFilename() {
		try {
			Aufgabe1.splitStudiengaenge("lorem");
			fail();			
		} catch (MatrikelNummerException e) {
			assertTrue(e.getMessage().equals("File not found"));
		}
	}
	
	@Test
	void wrongMatrikelNummer() {
		String filename = "test.txt";
		write(filename, "51000");

		try {
			Aufgabe1.splitStudiengaenge(filename);
			fail();			
		} catch (MatrikelNummerException e) {
			assertTrue(e.getMessage().equals("Matrikelnummer falsch"));
		}
	}
	
	@Test
	void filesWritten() {
		
	}
	
	void createTestDocument(String filename, String[] content) {
		File f = new File(filename);
		f.deleteOnExit();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
			
			for (int i = 0; i < content.length; i++) {			
				bw.write(content[i] + "\n");
			}
		} catch (IOException e) {
			fail();
		}
	}
	
	void write(String filename, String content) {
		File f = new File(filename);
		f.deleteOnExit();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
			bw.write(content + "\n");
		} catch (IOException e) {
			fail();
		}
	}
}
