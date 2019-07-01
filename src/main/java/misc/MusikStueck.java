package misc;

public class MusikStueck {
	protected String titel;
	protected String interpret;
	protected int laenge;
	
	public MusikStueck(String titel, String interpret, int laenge) {
		this.titel = titel;
		this.interpret = interpret;
		this.laenge = laenge;
	}
	
	@Override
	public String toString() {
		return "Titel: " + titel + " Interpet: " + interpret + " Laenge: " + laenge;
	}
}
