package misc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	String server;
	int port;
	boolean listen = true;

	public Client(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public static void main(String[] args) {
		Client c = new Client("localhost", 9000);
		c.startClient();
	}
	
	public void startClient() {
		String line;

		try (
			Socket con = new Socket(server, port);
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = con.getOutputStream();
			Scanner scanner = new Scanner(System.in);
		){
			Thread t1 = new Thread(new ClientThread(br));
			t1.start();

			while(listen) {
				line = scanner.nextLine();
				os.write(line.getBytes());
				os.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void kill() {
		this.listen = false;
	}
}
