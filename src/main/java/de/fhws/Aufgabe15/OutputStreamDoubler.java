package de.fhws.Aufgabe15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler extends OutputStream {
	OutputStream out1;
	OutputStream out2;
	
	public static void main(String[] args) throws FileNotFoundException {
		OutputStream out1 = new FileOutputStream("text2.txt");
		OutputStream out2 = new FileOutputStream("text2.txt");
		OutputStreamDoubler dout = new OutputStreamDoubler(out1, out2);
		byte[] b = { 1, 0 };
				
		try {
			dout.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public OutputStreamDoubler(OutputStream out1, OutputStream out2) {
		this.out1 = out1;
		this.out2 = out2;
	}

	@Override
	public void write(byte[] b) throws IOException {
		IOException err = null;
		
		try {
			out1.write(b);			
		} catch (IOException e) {
			err = e;
		}
		
		out2.write(b);

		if(err != null) throw err;		
	}
	
	public void close() throws IOException {
		out1.close();
		out2.close();
	}

	@Override
	public void write(int arg0) throws IOException {
		// TODO Auto-generated method stub
	}

}
