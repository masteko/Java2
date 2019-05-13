package de.fhws.Aufgabe17;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser {
	public static void main(String[] args) {
		System.out.println("Normal back");
		Browser browser = new Browser();
		Optional<URL> back = browser.back();
		if (back.isPresent()) browser.retrieveSite(back.get());
	}
	
	public Optional<URL> back() {
		Optional<URL> result = Optional.empty();
		try {
			//simulate: fetch last URL from Stack
			if (Math.random() < 0.5)
				result = Optional.of(new URL("http://google.de"));
		} catch (MalformedURLException e) {
		}
		return result;
	}
	
	public void retrieveSite(URL url) {
		System.out.println(url);
	}
}
