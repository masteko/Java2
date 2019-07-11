package misc;

import java.sql.Date;
import java.sql.Timestamp;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Message {
	private int charCounter;
	private String message;
	private String ceationDate;
	
	public Message(String message, String date) {
		this.message = message;
		this.ceationDate = date;
	}
	
	public String getCreationDate() {
		return this.ceationDate;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
