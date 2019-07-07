package misc;

public class Spieler {
	private String name;
	private int rank;
	
	public Spieler(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}
	
	public int getRanking() {
		return this.rank;
	}
	
	@Override
	public String toString() {
		return name + " mit Ranking " + rank;
	}
}
