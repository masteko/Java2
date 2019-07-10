package misc;

import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends Writer {
	Writer writer;
	int offset;
	
	public CaesarWriter(Writer w, int offset) {
		this.writer = w;
		this.offset = offset;
	}

	@Override 
	public void write(String s) throws IOException{
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] = (char) ((chars[i] - 'A' + offset) % 26 + 'A');
			} else {
				chars[i] = (char) ((chars[i] - 'a' + offset) % 26 + 'a');				
			}
		}		
		writer.write(String.valueOf(chars));
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		writer.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		writer.flush();		
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
