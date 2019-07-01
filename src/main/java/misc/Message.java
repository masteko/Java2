package misc;

import java.sql.Date;
import java.sql.Timestamp;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Message {
	private int charCounter;
	private String message;
	private String ceationDate;
	
	public Message(String message) {
		this.message = message;
		this.ceationDate = new Timestamp(System.currentTimeMillis()).toString();
	}
	
	public String getCreationDate() {
		return this.ceationDate;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
