package de.fhws.Aufgabe18;

public class Aufgabe3 {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		int i = 0;
		
		for (Student s : students) {
			s = new Student("Lennard der " + ++i + ".");
			System.out.println(s);
		}
	}

}
