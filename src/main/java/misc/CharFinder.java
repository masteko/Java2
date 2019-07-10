package misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharFinder extends Thread{
	String file;
	int sum;
	char searchChar;
	
	public CharFinder(String file, char searchChar) {
		this.file = file;
		this.searchChar = searchChar;
	}
	
	@Override
	public void run() {
		char[] arr = new char[2048];
		int r;
		int sum = 0;
		try (
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
				) {
			r = isr.read(arr);
			
			while(r != -1) {
				for (int i = 0; i < r; i++) {
					if(Character.toLowerCase(arr[i]) == Character.toLowerCase(this.searchChar)) {
						sum++;
					}
				}
				r = isr.read(arr);
			}
			
			this.sum = sum;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
