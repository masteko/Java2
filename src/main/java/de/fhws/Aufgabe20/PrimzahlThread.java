package de.fhws.Aufgabe20;

import java.util.HashMap;
import java.util.Map;

public class PrimzahlThread extends Thread {
	int[] zahlenZumTesten;
	Map<Integer, Boolean> ergebnis;
	
	public static void main(String[] args) {
		int[] zahlen1 = {1, 3, 8, 9, 10, 11, 15, 16, 17, 18, 19, 20, 21 };
		int[] zahlen2 = { 500, 501, 502, 503, 504 };
		int[] zahlen3 = { 321, 123, 231, 213, 132 };
		
		Thread t1 = new PrimzahlThread(zahlen1);
		Thread t2 = new PrimzahlThread(zahlen2);
		Thread t3 = new PrimzahlThread(zahlen3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}

	public PrimzahlThread(int[] zahlenZumTesten) {
		this.zahlenZumTesten = zahlenZumTesten;
		this.ergebnis = new HashMap<>();
	}

	public boolean testeObPrimzahl(int zahlZumTesten) {
		boolean istPrimzahl;
		if (zahlZumTesten < 2)
			istPrimzahl = false;
		else
			istPrimzahl = true;
		for (int divisor = 2; divisor < zahlZumTesten; divisor++) {
			if (zahlZumTesten % divisor == 0)
				istPrimzahl = false;
		}
		
		return istPrimzahl;
	}

	@Override
	public void run() {
		for (int zahl : zahlenZumTesten) {
			this.ergebnis.put(zahl, testeObPrimzahl(zahl));
		}
	}
	
	@Override
	public String toString() {
		return this.ergebnis.toString();
	}
}