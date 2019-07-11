package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	int port;
	boolean serverRunning = true;
	List<ServerConnection> connections;
	MsgReceiver receiver;

	public Server(int port) {
		this.port = port;
		
		this.receiver = ((msg) -> {
			System.out.println(msg);
		});
	}
	
	public void startServer() {
		serverRunning = true;
		connections = new ArrayList<>();
		System.out.println("Server started");

		try(ServerSocket ss = new ServerSocket(port);) {
			while(serverRunning) {
				Socket con = ss.accept();
				ServerConnection sc = new ServerConnection(con, receiver);
				connections.add(sc);
				sc.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		serverRunning = false;
		System.out.println("Server stopped");
	}
	
	public static void main(String[] args) {
		Server s = new Server(8000);
		s.startServer();
	}
}
