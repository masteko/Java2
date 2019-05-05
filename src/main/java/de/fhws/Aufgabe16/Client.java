package de.fhws.Aufgabe16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	int port;
	String host;
	
	public Client(String host, int port) {
		this.port = port;
		this.host = host;
	}
	
	public void connect() throws IOException {
		boolean running = true;
		
		try (
			Socket connection = new Socket(host, port);
			OutputStream os = connection.getOutputStream();
			InputStream is = connection.getInputStream();
			Scanner scanner = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		) {
			System.out.println("Willkommen bei Hangman! Errate das Word.");
			while(running) {
				receiveMessage(br);
				sendMessage(scanner.nextLine(), os);
			}			
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	private void receiveMessage(BufferedReader br) throws IOException {
		System.out.println(br.readLine());
	}
	
	private void sendMessage(String msg, OutputStream os) throws IOException {
		os.write((msg + "\n").getBytes());
		os.flush();
	}
	
	public static void main(String[] args) {
		Client client = new Client("localhost", 8080);
		try {
			client.connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
