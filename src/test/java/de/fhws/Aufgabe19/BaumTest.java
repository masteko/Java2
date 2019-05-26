/**
 * 
 */
package de.fhws.Aufgabe19;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author njest
 *
 */
class BaumTest {
	Baum b;
	String test1 = "Halma";
	String test2 = "Bertel";
	String test3 = "Cäsar";
	String test4 = "Anton";
	String test5 = "Ludwig";
	String test6 = "Julius";
	String test7 = "Carl";

	@BeforeEach
	void init() {
		b = new Baum();
	}
	
	@Test
	void noRootTest() {
		assertTrue(b.root ==null);
	}
	
	@Test
	void InsertTest() {
		fillWithTestData();
			
		assertTrue(b.root.name.equals(test1));
		assertTrue(b.root.left.name.equals(test2));
		assertTrue(b.root.left.right.name.equals(test3));
		assertTrue(b.root.left.left.name.equals(test4));
		assertTrue(b.root.right.name.equals(test5));
		assertTrue(b.root.right.left.name.equals(test6));
		assertTrue(b.root.left.right.left.name.equals(test7));
	}
	
	@Test
	void PrintTest() {
		assertTrue("".equals(b.toString()));
		fillWithTestData();
		assertTrue(generateTestString().equals(b.toString()));
	}
	
	void fillWithTestData() {
		b.add(test1);
		b.add(test2);
		b.add(test3);
		b.add(test4);
		b.add(test5);
		b.add(test6);
		b.add(test7);
	}

	String generateTestString() {
		String result = "";
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream ps = new PrintStream(baos);) {
			
			ps.println(test4); // = "Anton";
			ps.println(test2); // = "Bertel";
			ps.println(test7); // = "Carl";
			ps.println(test3); // = "Cäsar";
			ps.println(test1); // = "Halma";
			ps.println(test6); // = "Julius";
			ps.println(test5); // = "Ludwig";
			
			ps.flush();
			return baos.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
