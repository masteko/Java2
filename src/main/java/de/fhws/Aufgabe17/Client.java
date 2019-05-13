package de.fhws.Aufgabe17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
			ObjectOutputStream oos = new ObjectOutputStream(os);
			Scanner scanner = new Scanner(System.in);
		) {
			while(running) {
				Person p = createPerson(scanner);
				oos.writeObject(p);
				oos.flush();
			}			
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	private Person createPerson(Scanner scanner) {
		String name;
		String nachname;
		String telefon;
		
		System.out.println("Name:");
		name = scanner.nextLine();
		System.out.println("Nachname:");
		nachname = scanner.nextLine();
		System.out.println("Telefonnummer:");
		telefon = scanner.nextLine();
		
		return new Person(name, nachname, telefon);
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
