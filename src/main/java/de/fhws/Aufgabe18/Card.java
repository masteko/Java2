package de.fhws.Aufgabe18;

public class Card implements Comparable<Card>{
	Value value;
	Color color;
	
	public Card(Value value, Color color) {
		this.value = value;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Card: " + this.value + " " + this.color;
	}
	
	private int compareColorOrdinal(Card c) {
		if (this.color.ordinal() < c.color.ordinal()) {
			return -1;
		} else if (this.color.ordinal() > c.color.ordinal()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private int compareValueOrdinal(Card c) {
		if (this.value.ordinal() < c.value.ordinal()) {
			return -1;
		} else if (this.value.ordinal() > c.value.ordinal()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int compareTo(Card c) {
		if (this.value.equals(Value.Jack) || c.value.equals(Value.Jack)) {
			if (!c.value.equals(Value.Jack)) {
				return -1;
			} else if (!this.value.equals(Value.Jack)) {
				return 1;
			}	else {
				return compareColorOrdinal(c);
			}
		} else {
			int colorOrdinal = compareColorOrdinal(c);
			if (colorOrdinal == 0) {
				return compareValueOrdinal(c);
			} else {
				return colorOrdinal;
			}
		}
	}
}
