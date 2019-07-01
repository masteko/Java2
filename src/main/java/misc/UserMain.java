package misc;

import java.util.List;

public class UserMain {
	public static void main(String[] args) {
		UserManager um = new UserManager();
//		List<User> users = List.of(
//			new User("Igor", "Wodka"),
//			new User("njester", "5030"),
//			new User("Becky", "Bourton")
//		);
//		
//		um.serialize(users);
		
		List<User> users = um.deserialize();
		users.forEach(System.out::println);
	}
}
