package misc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	int port;
	ArrayList<Socket> connections;
	boolean running = true;
	
	public Server(int port) {
		this.connections = new ArrayList<>();
		this.port = port;
	}
	
	public static void main(String[] args) {
		Server s = new Server(9000);
		s.startServer();
	}
	
	public void startServer() {
		System.out.println("server running");
		try (
			ServerSocket server = new ServerSocket(port);
		) {
			while(running) {
				Socket connection = server.accept();
				connections.add(connection);
				new Thread(new ServerThread(connection)).start();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		running = false;
	}
}
