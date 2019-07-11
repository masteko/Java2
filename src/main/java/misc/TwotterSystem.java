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
		return messages.values().stream().flatMap(msgs -> msgs.stream()).collect(Collectors.toList());
	}
	
	public List<Message> getAllMessagesFromUser(User u) {
		return messages.get(u);
	}
	
	public List<Message> getAllMessagesFromDate(String date) {
		return messages.values().stream()
				.flatMap(msgs -> msgs.stream())
				.filter(m -> m.getCreationDate().equals(date))
				.collect(Collectors.toList());
	}
}
