package de.fhws.Aufgabe15;
import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileRipper {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean fileFound = true;
		long startTime;
		long duration;
		
		System.out.println(System.getProperty("user.dir"));
		
		do {
			System.out.println("Gebe den Dateinamen ein");
			String file = scanner.nextLine();
			
			String[] arr = file.split("\\.");
			arr[0] += "_copy";

			startTime = System.currentTimeMillis();
			try (InputStream in = new FileInputStream(file);
					OutputStream out = new FileOutputStream(concat(arr, "."));) {
				fileFound = true;
				
				buffered(in, out);
				duration = System.currentTimeMillis() - startTime;
				System.out.println("Buffered took " + duration + "ms");
				
			} catch (FileNotFoundException e) {
				System.out.println("Datei konnte nicht gefunden werden. Versuchen Sie es erneut");
				fileFound = false;
			} catch (IOException e) {
				System.out.println("Leider ging etwas schief");
			}
			
			startTime = System.currentTimeMillis();
			try (InputStream in = new FileInputStream(file);
					OutputStream out = new FileOutputStream(concat(arr, "."));) {
				
				unbuffered(in, out);
				duration = System.currentTimeMillis() - startTime;
				System.out.println("Unbuffered took " + duration + "ms");
				
			} catch (FileNotFoundException e) {
				System.out.println("Datei konnte nicht gefunden werden. Versuchen Sie es erneut");
				fileFound = false;
			} catch (IOException e) {
				System.out.println("Leider ging etwas schief");
			}
			
		} while (!fileFound);
		
		scanner.close();
		
	}
	
	static void unbuffered(InputStream in, OutputStream out) throws IOException {
		byte[] b = new byte[4096];
		int offset;
		
		do {
			offset = in.read(b);
			if (offset != -1) out.write(b, 0, offset);
		} while(offset != -1);
	}
	
	static void buffered(InputStream in, OutputStream out) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(in);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		byte[] b = new byte[4096];
		int offset;
		
		do {
			offset = bin.read(b);
			if (offset != -1) bout.write(b, 0, offset);
		} while(offset != -1);
	}
	
	public static String concat(String[] arr, String symbol) {
		String result = "";
		
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] + symbol;
		}
		
		return result.substring(0, result.length() - 1);
	}

}
