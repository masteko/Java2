package de.fhws.Aufgabe16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneNumberTest {
	File inputFile;
	File outputFile;
	
	@BeforeEach
	void init() {
		inputFile = new File("test.txt");		
		inputFile.deleteOnExit();
		outputFile = new File("out.txt");
		outputFile.deleteOnExit();		
	}

	@Test
	void rightNumberTest() throws IOException, IllegalPhoneNumberException {	
		createTestFile("aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ");
		PhoneNumber pn = new PhoneNumber(inputFile.getName(), outputFile.getName());
		pn.generatePhoneNumberFile();
		String content = readOutputFile();
		
		assertTrue(content.equals("2222223333334444445555556666667777777788888899999999"));
	}
	
	@Test
	void illegalNumberFirstTest() throws IOException {
		createTestFile("[bcd");
		PhoneNumber pn = new PhoneNumber(inputFile.getName(), outputFile.getName());
		try {
			pn.generatePhoneNumberFile();
			fail();
		} catch (IllegalPhoneNumberException e) {
			String content = readOutputFile();
			char[] test = content.toCharArray();
			
			for (int i = 0; i< test.length; i++) {
				System.out.println(i + ": " + test[i] );
			}
			assertTrue(content.equals("223"));
		}
	}
	
	@Test
	void illegalNumberSecondTest() throws IOException {
		createTestFile("@yz");
		PhoneNumber pn = new PhoneNumber(inputFile.getName(), outputFile.getName());
		try {
			pn.generatePhoneNumberFile();
			fail();
		} catch (IllegalPhoneNumberException e) {
			String content = readOutputFile();
			char[] test = content.toCharArray();
			
			for (int i = 0; i< test.length; i++) {
				System.out.println(i + ": " + test[i] );
			}
			assertTrue(content.equals("99"));
		}
	}
	
	void createTestFile(String content) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
		
		bw.write(content);
		bw.close();
	}
	
	String readOutputFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(outputFile));
		String result;
		
		result =  br.readLine();
		br.close();
		
		return result;
	}
}
