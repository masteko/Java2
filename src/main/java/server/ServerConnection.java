package server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection extends Thread {
	Socket con;
	boolean running = true;
	MsgReceiver receiver;
	
	public ServerConnection(Socket con, MsgReceiver receiver) {
		this.con = con;
		this.receiver = receiver;
	}

	public void run() {
		try (InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			System.out.println("Listening to " + con.getLocalAddress());
			while(running) {
				System.out.println("warte auf Input" + con);
				String line = is.readAllBytes().toString();
				System.out.println("erhalte " + line);
				receiver.MsgReceived(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
