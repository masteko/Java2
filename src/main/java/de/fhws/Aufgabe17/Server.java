package de.fhws.Aufgabe17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	int port;
	ArrayList<Person> personen;
	
	public Server(int port) {
		this.personen = new ArrayList<>();
		this.port = port;
	}
		
	public void listen() throws IOException {
		boolean runServer = true;
		
		try (
			ServerSocket ss = new ServerSocket(port);
			Socket connection = ss.accept();
			InputStream is = connection.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
		) {
			System.out.println("Server running");

			while(runServer) {
				personen.add( (Person) ois.readObject());
				printPersonen();
			}
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	public void printPersonen() {
		for (Person p : personen) {
			System.out.println(p);
		}
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
