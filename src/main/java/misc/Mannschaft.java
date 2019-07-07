package misc;

import java.util.ArrayList;

public class Mannschaft {
	private String name;
	private ArrayList<Spieler> spielerListe;
	
	public Mannschaft(String name) {
		this.name = name;
		spielerListe = new ArrayList<>();
	}
	
	public double getAverageRanking() {
		return spielerListe.stream().mapToInt(Spieler::getRanking).average().orElse(0);
	}
	
	@Override
	public String toString() {
		String result = "";
		int index = 1;
		for (Spieler spieler : spielerListe) {
			result += index++ + " " + spieler + "\n";
		}
		
		result += "Durchschnittsranking: " + getAverageRanking() + "\n";
		
		return result;
	}
	
	public static void main(String[] args) {
		Mannschaft mA = new Mannschaft("MannschaftA");
		mA.spielerListe.add(new Spieler("SpielerA", 10));
		mA.spielerListe.add(new Spieler("SpielerB", 5));
		mA.spielerListe.add(new Spieler("SpielerC", 5));
		mA.spielerListe.add(new Spieler("SpielerD", 7));
		
		System.out.println(mA);
	}
}
