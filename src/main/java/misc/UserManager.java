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
			for (User u : users) {
				oos.writeObject(u);
			}
			
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
			tmp = (User) ois.readObject();
			while(tmp != null) {
				result.add(tmp);
				tmp = (User) ois.readObject();
			}
		} catch(EOFException e) {
			
		} catch(IOException e) {
			throw new RuntimeException(e);
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
}
