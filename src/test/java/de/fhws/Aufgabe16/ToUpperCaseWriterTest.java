package de.fhws.Aufgabe16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

class ToUpperCaseWriterTest {

	@Test
	void uperCaseTest() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(baos);
			ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {
			
			writer.write('a');
			writer.flush();
			String uppercase = baos.toString();
			assertEquals(uppercase, "A");
			
		} catch (Exception e) {
			fail("IOException" + e.getMessage());
		}
	}
	
	@Test
	void numberTest() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(baos);
			ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {
			
			writer.write('1');
			writer.flush();
			String uppercase = baos.toString();
			assertEquals(uppercase, "1");
			
		} catch (Exception e) {
			fail("IOException" + e.getMessage());
		}
	}
	
	@Test
	void asciTest() {
		char c;
		byte[] arr;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(baos);
			ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {
			
			for(int i = 0; i < 128; i++) {
				writer.write(i);
			}
			writer.flush();
			arr = baos.toByteArray();
			System.out.println(baos.toString());
			
			for (int i = 0; i < 128; i++) {
				if (i >= 97 && i <= 122) {
					assertEquals(i - 32, arr[i]);
				} else {
					assertEquals(i, arr[i]);					
				}
			}
		} catch (Exception e) {
			fail("IOException" + e.getMessage());
		}
	}

}
