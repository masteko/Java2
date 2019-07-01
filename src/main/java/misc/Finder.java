package misc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import org.glassfish.jersey.internal.guava.Lists;
import org.glassfish.jersey.internal.util.collection.ByteBufferInputStream;

public class Finder {
	public BufferedReader getSystemInAsBufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void findStringInFiles(String searchString, String[] filenames) {
		String line;
		int lineNumber;
	
		for (String filename : filenames) {
			try (
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
			){
				line = br.readLine();
				lineNumber = 1;
				while(line != null) {
					if (line.contains(searchString)) {
						System.out.println(searchString + " kommt in der Datei " + filename + " in Zeile " + lineNumber + " vor.");
					}
					line = br.readLine();
					lineNumber++;
				}
			} catch (Exception e) {
				System.out.println("Datei: " + filename + " konnte nicht gefunden werden.");
			}
		}
	}
	
	public static void main(String[] args) {
		Finder finder = new Finder();
		BufferedReader br = finder.getSystemInAsBufferedReader();
		String searchString = null;
		
		try {
			searchString = br.readLine();
			finder.findStringInFiles(searchString, "text1.txt,text2.txt".split(","));
			br.close();
		} catch (IOException ex) {
			System.out.println("Einlesen fehlgeschlagen");
		}
	}
}
