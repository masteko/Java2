package de.fhws.Aufgabe21;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

import de.fhws.Aufgabe15.OutputStreamDoubler;

public class Browser {
	public static void main(String[] args) {
		System.out.println("Normal back");
		Browser browser = new Browser();
		Optional<URL> back = browser.back();
		back.ifPresent(url -> System.out.println(url));
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
