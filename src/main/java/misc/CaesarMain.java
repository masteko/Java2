package misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class CaesarMain {
	public static void main(String[] args) {
		try {
			CaesarWriter cw = new CaesarWriter(new OutputStreamWriter(System.out), 5);
			cw.write("Hallo");
			cw.flush();
			
			BufferedReader bf = new BufferedReader(new CaesarReader(new FileReader("caesar.txt"), 5));
			String line = bf.readLine();
			bf.close();
			System.out.println(line);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
