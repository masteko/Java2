package de.fhws.Aufgabe20;

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
		try (
			ServerSocket ss = new ServerSocket(port)
		) {
			while(true) {
				Thread t = new ServerThread(ss.accept());
				t.start();
			}
		} catch (Exception e) {
			throw new IOException(e);
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
