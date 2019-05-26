package de.fhws.Aufgabe19;

import java.io.ObjectInputStream.GetField;

public class Naehrstoffangaben {
	// mandatory
	int portionsGroesse;
	int anzahlPortionen;
	
	// optional
	int eiweiss;
	int fett;
	int kohlenhydrate;
	int natrium;
	
	public static void main(String[] args) {
		Naehrstoffangaben nsa = new Naehrstoffangaben.NaehrstoffangabenBuilder(100, 200)
				.withEiweiss(300)
				.withFett(400)
				.withKohlenhydrate(500)
				.withNatrium(600)
				.build();
		
		System.out.println(nsa);
	}
	
	private Naehrstoffangaben(int portionsGroesse, int anzahlPortionen, int eiweiss, int fett, int kohlenhydrate, int natrium) {
		this.portionsGroesse = portionsGroesse;
		this.anzahlPortionen = anzahlPortionen;
		this.eiweiss = eiweiss;
		this.kohlenhydrate = kohlenhydrate;
		this.natrium = natrium;
		this.fett = fett;
	}
	
	@Override
	public String toString() {
		return String.format("Portionsgroesse: %d, AnzahlPortionen: %d, Eiweiss: %d, Fett: %d, Kohlenhydrate: %d, Natrium: %d", portionsGroesse, anzahlPortionen, eiweiss, fett, kohlenhydrate, natrium);
	}
	
	public static class NaehrstoffangabenBuilder {
		// mandatory
		int portionsGroesse;
		int anzahlPortionen;
		
		// optional
		int eiweiss;
		int fett;
		int kohlenhydrate;
		int natrium;
		
		public NaehrstoffangabenBuilder(int portionsGroesse, int anzahlPortionen) {
			this.portionsGroesse = portionsGroesse;
			this.anzahlPortionen = anzahlPortionen;
		}
		
		public NaehrstoffangabenBuilder withEiweiss(int eiweiss) {
			this.eiweiss = eiweiss;
			return this;
		}
		
		public NaehrstoffangabenBuilder withKohlenhydrate(int kohlenhydrate) {
			this.kohlenhydrate = kohlenhydrate;
			return this;
		}
		
		public NaehrstoffangabenBuilder withFett(int fett) {
			this.fett = fett;
			return this;
		}
		
		public NaehrstoffangabenBuilder withNatrium(int natrium) {
			this.natrium = natrium;
			return this;
		}
		
		public Naehrstoffangaben build() {
			return new Naehrstoffangaben(portionsGroesse, anzahlPortionen, eiweiss, fett, kohlenhydrate, natrium);
		}
		
	}
}
