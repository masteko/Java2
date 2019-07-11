package misc;

import java.util.HashMap;

public class Morse {
	public static String[][] tabelle = {
			{ "A", ".-" },
			{ "B", "-..." },
			{ "C", "-.-." },
			{ "D", "-.." },
			{ "E", "." },
			{ "F", "..-." },
			{ "G", "--." },
			{ "H", "...." },
			{ "I", ".." },
			{ "J", ".---" },
			{ "K", "_._" },
			{ "L", ".-.." },
			{ "M", "--" },
			{ "N", "-." },
			{ "O", "---" },
			{ "P", ".--." },
			{ "Q", "--.-" },
			{ "R", ".-." },
			{ "S", "..." },
			{ "T", "-" },
			{ "U", "..-" },
			{ "V", "...-" },
			{ "W", ".--" },
			{ "X", "-..-" },
			{ "Y", "-.--" },
			{ "Z", "--.." },
	};
	
	public static HashMap<String, String> getMorseCodeMap(String[][] table) {
		HashMap<String, String> result = new HashMap<>();
		
		for (String[] zeile : table) {
			result.put(zeile[0], zeile[1]);
		}
		
		return result;
	}
	
	public static String zeichenketteToMorse(String msg) {
		HashMap<String, String> code = getMorseCodeMap(tabelle);
		String result = "";
		
		for (char c : msg.toCharArray()) {
			result += code.get(String.valueOf(c).toUpperCase());
			result += " ";
		}
		
		return result.trim();
	}

	public static void main(String[] args) {
		System.out.println(zeichenketteToMorse("Klausurerfolg"));
	}
}
