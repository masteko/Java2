package misc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Testing {
	
	public static void main(String[] args) {
		//copyFile("orange.mp3", "banana.mp3");
		
//		writeRandomFile("file.txt");
		
		CharFinder aReader = new CharFinder("file.txt", 'a');
		CharFinder bReader = new CharFinder("file.txt", 'b');
		CharFinder cReader = new CharFinder("file.txt", 'c');
		CharFinder xReader = new CharFinder("file.txt", 'x');
		CharFinder oneReader = new CharFinder("file.txt", '1');
		
		
		try {
			aReader.start();
//			aReader.join();
			bReader.start();
//			bReader.join();
			cReader.start();
//			cReader.join();
			xReader.start();
//			xReader.join();
			oneReader.start();

			aReader.join();
			bReader.join();
			cReader.join();
			xReader.join();
			oneReader.join();
			System.out.println("Anzahl von a/As: " + aReader.sum);
			System.out.println("Anzahl von b/Bs: " + bReader.sum);
			System.out.println("Anzahl von c/Cs: " + cReader.sum);
			System.out.println("Anzahl von x/Xs: " + xReader.sum);
			System.out.println("Anzahl von 1en: " + oneReader.sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void copyFile(String inputFile, String outputFile) {
		try (FileInputStream fis = new FileInputStream(inputFile);
			FileOutputStream fos = new FileOutputStream(outputFile);) {
			
				byte[] b = new byte[(int) Math.pow(2, 16)];
				int v = 0;
				
				v = fis.read(b);
				
				while(v != -1) {
					fos.write(b, 0, v);
					v = fis.read(b);
				}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeRandomFile(String file) {
		char[] arr = new char[(int) Math.pow(2, 26)];
		
		for (int i = 0; i < arr.length; i++) {
			if (Math.random() >= 0.5) {
				arr[i] = (char) (Math.random() * 26 + 97);
			} else {
				arr[i] = (char) (Math.random() * 26 + 65);
			}
		}
			
		try (
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
		) {
			osw.write(arr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void anotherReadFunction(String file) {
		String total = "";
		String line;
		int sum = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			line = br.readLine();
			
			while (line != null) {
				total += line;
				line = br.readLine();
			}
			
//			int count = (count) Arrays.asList(total.toCharArray()).stream().filter(c -> (c == 'b' || c == 'B')).count();
			for (char c : total.toCharArray()) {
				if (c == 'b' || c == 'B') {
					sum++;
				}
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
