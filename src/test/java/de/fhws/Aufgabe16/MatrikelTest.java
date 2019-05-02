package de.fhws.Aufgabe16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		try {
			createTestDocument(filename, "51000");
			Aufgabe1.splitStudiengaenge(filename);
			fail();			
		} catch (MatrikelNummerException e) {
			assertTrue(e.getMessage().equals("Matrikelnummer falsch 51000"));
		}
		
		try {
			createTestDocument(filename, "550000");
			Aufgabe1.splitStudiengaenge(filename);
			fail();			
		} catch (MatrikelNummerException e) {
			assertTrue(e.getMessage().equals("Matrikelnummer falsch 550000"));
		}
		
		try {
			createTestDocument(filename, "6200000");
			Aufgabe1.splitStudiengaenge(filename);
			fail();			
		} catch (MatrikelNummerException e) {
			assertTrue(e.getMessage().equals("Matrikelnummer falsch 6200000"));
		}
	}
	
	@Test
	void filesWritten() {
		String filename = "test2.txt";
		String[] arr = { "5100000",
				"5199999",
				"5000000",
				"5099999",
				"6100000",
				"6199999"};
		
		List<String> winfList = new ArrayList<>();
		List<String> infList = new ArrayList<>();
		List<String> ecList = new ArrayList<>();
		
		List<String> winfListReader= new ArrayList<>();
		List<String> infListReader = new ArrayList<>();
		List<String> ecListReader = new ArrayList<>();
		
		winfList.add(arr[2]);
		winfList.add(arr[3]);
		
		infList.add(arr[0]);
		infList.add(arr[1]);
		
		ecList.add(arr[4]);
		ecList.add(arr[5]);
		
		createTestDocument(filename, arr);
		
		try {
			Aufgabe1.splitStudiengaenge(filename);			
		} catch (MatrikelNummerException e) {
			fail(e.getMessage());
		}
		
		try (BufferedReader winf = new BufferedReader(new FileReader("WInfNr.txt"));
			BufferedReader bin = new BufferedReader(new FileReader("InfNr.txt"));
			BufferedReader ec = new BufferedReader(new FileReader("ECNr.txt"));) {
			
			readEntries(winf, winfListReader);
			readEntries(bin, infListReader);
			readEntries(ec, ecListReader);
			
			assertTrue(winfList.equals(winfListReader));			
			assertTrue(infList.equals(infListReader));
			assertTrue(ecList.equals(ecListReader));
		} catch (IOException e) {
			fail();
		}
	}
	
	private void readEntries(BufferedReader winf, List<String> winfListReader) throws IOException {
		String line;
		
		do {
			line = winf.readLine();
			if (line == null) break;
			winfListReader.add(line);
		} while(true);
	}

	void createTestDocument(String filename, String[] content) {
		File f = new File(filename);
		f.deleteOnExit();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
			
			for (int i = 0; i < content.length; i++) {			
				bw.write(content[i] + "\n");
			}
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	void createTestDocument(String filename, String content) {
		File f = new File(filename);
		f.deleteOnExit();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
			bw.write(content + "\n");
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
