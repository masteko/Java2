package misc;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class UserManager {
	final String DATABASE = "users.db";

	public void serialize(List<User> users ) {
		try(
			FileOutputStream fos = new FileOutputStream(DATABASE);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) 
		{
//			for (User u : users) {
//				oos.writeObject(u);
//			}
			
			oos.writeObject(users);
			
		}catch (IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<User> deserialize() {
		List<User> result = new ArrayList<>();
		User tmp;
		
		try(
			FileInputStream fis = new FileInputStream(DATABASE);
			ObjectInputStream ois = new ObjectInputStream(fis);) 
		{
//			try {
//				while(true) {
//					tmp = (User) ois.readObject();
//					result.add(tmp);
//				}				
//			} catch (EOFException e) {
//				// no more users
//			}
			Object o = ois.readObject();
		} catch(IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
}
