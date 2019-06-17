package de.fhws.SS17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WortVorkommen {
	Map<Wort, Collection<Position>> woerter;
	
	public WortVorkommen() {
		this.woerter = new HashMap<>();
	}

	public Position holeLetztePosition(Wort w) {
		Collection<Position> positionen = woerter.get(w);
		
		if (positionen != null) {
			return positionen.stream().sorted().collect(Collectors.toList()).get(positionen.size() -1);
		} else {
			return null;
		}
	}

	public Collection<Position> holeAlle(Wort w) {
		return woerter.get(w);
	}

	public int anzahlVorkommen(Wort w) {
		Collection<Position> positionen = woerter.get(w);
		
		if (positionen != null) {
			return positionen.size();
		} else {
			return 0;
		}
	}

	public void einfuegen(Wort w, Position position) {
		Collection<Position> positionen = woerter.get(w);
		if(positionen != null) {
			positionen.add(position);
		} else {
			ArrayList<Position> list = new ArrayList<>();
			list.add(position);
			woerter.put(w, list);
		}
	}
}
