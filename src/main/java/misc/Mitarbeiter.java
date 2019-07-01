package misc;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.fhws.Aufgabe15.OutputStreamDoubler;

public class Mitarbeiter implements Serializable {
	private String vorname = null;
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getGehalt() {
		return gehalt;
	}

	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	private String nachname = null;
	private int nummer = 0;
	transient private int gehalt = 0;
	
	public Mitarbeiter(String vorname, String nachname, int nummer, int gehalt) {
		this.nummer = nummer;
		this.gehalt = gehalt;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	@Override
	public String toString() {
		return "Nachname: " + nachname + " Vorname: " + vorname + " Personalnummer: " + nummer + " Gehalt: " + gehalt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		
		if(!(obj instanceof Mitarbeiter)) {
			return false;
		}
		
		Mitarbeiter other = (Mitarbeiter) obj;
		if (gehalt != other.gehalt) {
			return false;
		}
		if (!vorname.equals(other.vorname)) {
			return false;
		}
		if(!nachname.equals(other.nachname)) {
			return false;
		}
		
		return true;
	}
	
	public static Mitarbeiter[] sortiere(Collection<Mitarbeiter> team) {
		return team.stream().sorted(new VergleichePersonalNummer()).toArray(Mitarbeiter[]::new);
	}
	
	public static void main(String[] args) {
		Mitarbeiter m1 = new Mitarbeiter("Igor", "Wodka", 4711, 28000);
		Mitarbeiter m2 = new Mitarbeiter("Putin", "Bläad", 815, 18000);
		Mitarbeiter m3 = new Mitarbeiter("Pommes", "Schranke", 1337, 48000);
		
		
		try (
			FileOutputStream fos = new FileOutputStream("mitarbeiter.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(m1);
			oos.writeObject(m2);
			oos.writeObject(m3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<Mitarbeiter> mitarbeiter = new HashSet<>();
		
		try (
			FileInputStream fis = new FileInputStream("mitarbeiter.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			while(true) {
				mitarbeiter.add((Mitarbeiter) ois.readObject());
			}
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mitarbeiter.forEach(System.out::println);
		Mitarbeiter[] m = Mitarbeiter.sortiere(mitarbeiter);
		for (Mitarbeiter ma : m) {
			System.out.println(ma);
		}
	}
	
}
