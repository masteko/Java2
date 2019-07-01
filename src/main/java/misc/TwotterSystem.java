package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TwotterSystem {
	Map<User, List<Message>> messages;
	
	public TwotterSystem() {
		messages = new HashMap<>();
	}

	public void addMessage(User u, Message msg) {
		List<Message> m = messages.get(u);
		if (m == null) {
			m = new ArrayList<>();
			messages.put(u, m);
		}
		m.add(msg);
	}
	
	public List<Message> getAllMessages() {
		List<Message> result = new ArrayList<>();
		messages.forEach((u, m) -> result.addAll(m));
		return result;
	}
	
	public List<Message> getAllMessagesFromUser(User u) {
		return messages.get(u);
	}
	
	public List<Message> getAllMessagesFromDate(String date) {
		List<Message> result = new ArrayList<>();
		messages.forEach((u, m) -> result.addAll(m));
		return result.stream().filter(m -> m.getCreationDate() == date).collect(Collectors.toList());
	}
}
