package de.fhws.Aufgabe16;

import java.io.IOException;
import java.io.Writer;

public class ToUpperCaseWriter extends Writer {
	Writer os;
	
	public ToUpperCaseWriter(Writer os) {
		this.os = os;
	}

	@Override
	public void close() throws IOException {
		os.close();
	}

	@Override
	public void flush() throws IOException {
		os.flush();
		
	}
	
	public void write(char c) throws IOException {
		os.write(Character.toUpperCase(c));
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = off; i < off + len; i++) {
			write(cbuf[i]);
		}		
	}
	
	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}

}
