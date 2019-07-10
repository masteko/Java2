package misc;

import java.util.List;

public class Stockwerk {
	List<Raum> raeume;
	
	public Stockwerk(List<Raum> raeume) {
		this.raeume = raeume;
	}
	
	List<Raum> getRaeume() {
		return this.raeume;
	}
	
	public int getQuadratmeter() {
		return this.raeume.stream().mapToInt(Raum::getQuadratmeter).sum();
	}
}
