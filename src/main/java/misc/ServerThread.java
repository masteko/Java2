package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import de.fhws.Aufgabe20.DuplicateInputException;
import de.fhws.Aufgabe20.GameOverException;
import de.fhws.Aufgabe20.Hangman;

public class ServerThread implements Runnable {
	Socket con;
	boolean listen = true;
	
	public ServerThread(Socket con) {
		this.con = con;
	}

	@Override
	public void run() {
		String line;
		Hangman h = new Hangman();
		boolean victory = false;

		try(
			InputStream is = con.getInputStream();
			OutputStream os = con.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		) {
			sendMessage("Verbindung hergestellt", os);
			sendMessage(h.toString(), os);
			while(listen) {
				line = br.readLine();
				System.out.println("guess: " + line);
				try {
					victory = h.guess(line.charAt(0));
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
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg, OutputStream os) throws IOException {
		os.write(msg.getBytes());
		os.flush();
	}

}
