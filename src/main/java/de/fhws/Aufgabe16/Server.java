package de.fhws.Aufgabe16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	
	public Server(int port) {
		this.port = port;
	}
		
	public void listen() throws IOException {
		boolean runServer = true;
		Hangman h = new Hangman();
		char guess;
		boolean victory;
		
		try (
			ServerSocket ss = new ServerSocket(port);
			Socket connection = ss.accept();
			InputStream is = connection.getInputStream();
			OutputStream os = connection.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		) {
			sendMessage(h.toString(), os);
			while(runServer) {
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
		} catch (Exception e) {
			throw new IOException(e);
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
	
	public static void main(String[] args) {
		Server s = new Server(8080);
		try {
			s.listen();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
