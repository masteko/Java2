package de.fhws.Aufgabe18;

public class Aufgabe3 {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student("Lennard der " + i + ".");
		}
		
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
