package misc;

public class Twotter {
	public static void main(String[] args) {
		TwotterSystem sys = new TwotterSystem();
		
		User u = new User("Igor", "Wodka");
		User s = new User("Basd", "Wodka");
		sys.addMessage(u, new Message("Hello World"));
		sys.addMessage(u, new Message("bla"));
		sys.addMessage(s, new Message("ih"));
		sys.getAllMessages().forEach(System.out::println);
	}
}
