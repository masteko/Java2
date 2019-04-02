package de.fhws.Aufgabe13;

public abstract class Person {
	abstract void gibTaetigkeitAus();
	
	public static void main(String[] args) {
		Person p[] = createPersonArray();
		printPersonArray(p);
	}
	
	static Person[] createPersonArray() {
		Person result[] = new Person[100];

		for (int i = 0; i < result.length; i++) {
			result[i] = (i %2 == 0) ? new Student() : new Professor();
		}
		
		return result;
	}
	
	static void printPersonArray(Person[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i].gibTaetigkeitAus();
		}
	}
}
