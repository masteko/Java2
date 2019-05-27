package de.fhws.Aufgabe20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket con;
	
	public ServerThread(Socket con) {
		this.con = con;
	}
	
	
	@Override
	public void run() {
		Hangman h = new Hangman();
		char guess;
		boolean victory;

		try(
			InputStream is = con.getInputStream();
			OutputStream os = con.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is))
		) {
			System.out.println("Server running");;
			sendMessage(h.toString(), os);
			
			while(true) {
				guess = receiveMessage(br);
				try {
					victory = h.guess(guess);
					if (victory) {
						sendMessage("Gewonnen", os);																	
					}
					sendMessage(h.toString(), os);											
				} catch (DuplicateInputException e) {
					sendMessage("Buchstabe wurde bereits erraten", os);
				} catch (GameOverException e) {
					sendMessage("Keine Züge mehr möglich - Verloren", os);
				}
			}	
		} catch (IOException e) {
		}
	}
	
	private char receiveMessage(BufferedReader br) throws IOException {
		char guess = br.readLine().charAt(0);
		System.out.println("Guess: " + guess);
		return guess;
	}
	
	private void sendMessage(String msg, OutputStream os) throws IOException {
		os.write((msg + "\n").getBytes());
		os.flush();
	}
}
