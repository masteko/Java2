package misc;

public class Twotter {
	public static void main(String[] args) {
		TwotterSystem sys = new TwotterSystem();
		
		User u = new User("Igor", "Wodka");
		sys.addMessage(u, new Message("Hello World"));
		sys.getAllMessages().forEach(System.out::println);
	}
}
