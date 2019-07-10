package misc;

import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends Reader {
	Reader reader;
	int offset;
	
	public CaesarReader(Reader reader, int offset) {
		this.offset = offset;
		this.reader = reader;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int result = reader.read(cbuf, off, len);
		
		for (int i = 0; i < cbuf.length; i++) {
			if (cbuf[i] >= 'A' && cbuf[i] <= 'Z') {
				cbuf[i] = (char) ((cbuf[i] - 'A' - offset) %26 + 'A');
			} else if (cbuf[i] >= 'a' && cbuf[i] <= 'z') {
				cbuf[i] = (char) ((cbuf[i] - 'a' - offset) %26 + 'a');				
			}
		}
		
		return result;
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}

}
