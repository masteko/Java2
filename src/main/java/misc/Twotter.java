package misc;

public class Twotter {
	public static void main(String[] args) {
		TwotterSystem sys = new TwotterSystem();
		
		User u = new User("Igor", "Wodka");
		User s = new User("Basd", "Wodka");
		sys.addMessage(u, new Message("Hello World", "20.07.2019"));
		sys.addMessage(u, new Message("bla", "21.07.2019"));
		sys.addMessage(s, new Message("ih", "21.07.2019"));
		sys.getAllMessages().forEach(System.out::println);
		System.out.println("---------");
		sys.getAllMessagesFromDate("21.07.2019").forEach(System.out::println);
	}
}
