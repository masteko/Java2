package de.fhws.SS17;

public class Position implements Comparable<Position> {
	int zeilennummer;
	int spaltennummer;
	
	public Position(int z, int s) {
		this.zeilennummer = z;
		this.spaltennummer = s;
	}

	@Override
	public int compareTo(Position o) {
		if (this.zeilennummer == o.zeilennummer) {
			return this.spaltennummer - o.spaltennummer;
		} else {
			return this.zeilennummer - o.zeilennummer; 
		}
	}
	
	@Override
	public String toString() {
		return "Zeilennummer: " + zeilennummer + " Spaltennummer: " + spaltennummer;
	}
}
