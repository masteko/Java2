package misc;

import java.io.Serializable;

public class User implements Serializable, Comparable<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String name;
	transient final String password;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
