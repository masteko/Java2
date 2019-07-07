package misc;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread implements Runnable {
	BufferedReader br;
	
	public ClientThread(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		System.out.println("ClientThread läuft");
		while(true) {
			try {
				System.out.println(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
