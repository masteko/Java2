package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	int port;
	String host;
	
	public Client(int port, String host) {
		this.host = host;
		this.port = port;
	}
	
	public void connectToServer() {
		try (Socket s = new Socket(host, port);
			Scanner scn = new Scanner(System.in);
			OutputStream os = s.getOutputStream();) {
			System.out.println("Client connected " + s);
			while(true) {
				String msg = scn.nextLine();
				System.out.println("schreibe " + msg + " an server");
				os.write("hallo".getBytes());
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client c = new Client(8000, "localhost");
		c.connectToServer();
	}
}
