package misc;

import java.util.List;

public class UserMain {
	public static void main(String[] args) {
		UserManager um = new UserManager();
//		List<User> users = List.of(
//			new User("User1", "PW1"),
//			new User("User2", "PW2"),
//			new User("User3", "PW3")
//		);
//		
//		um.serialize(users);
		
		List<User> users = um.deserialize();
		users.forEach(System.out::println);
	}
}
