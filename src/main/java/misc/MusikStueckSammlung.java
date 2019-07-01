package misc;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.glassfish.jersey.internal.guava.Maps;

public class MusikStueckSammlung {
	HashMap<String, MusikStueck> sammlung;
	
	public MusikStueckSammlung() {
		sammlung = new HashMap<>();
	}
	
	public void musikStueckEinfuegen(MusikStueck neu) throws IllegalArgumentException{
		MusikStueck m = sammlung.putIfAbsent(neu.titel, neu);
		
		if (m != null) throw new IllegalArgumentException("MusikStueck " + neu.titel + " ist bereits vorhanden");
	}
	
	public MusikStueck[] getAlleMusikStueckeNachTitel() {
		MusikStueck[] result = sammlung.values().toArray(MusikStueck[]::new);
		Arrays.sort(result, new VergleicheMusikStueckTitel());
		return result;
	}
	
	public MusikStueck[] getAlleMusikStueckeNachLaenge() {
		MusikStueck[] result = sammlung.values().toArray(MusikStueck[]::new);
		Arrays.sort(result, new VergleicheMusikStuckLaenge());
		return result;
	}
	
	public static void main(String[] args) {
		MusikStueckSammlung mss = new MusikStueckSammlung();
		mss.musikStueckEinfuegen(new MusikStueck("Thriller", "Michael", 123));
		mss.musikStueckEinfuegen(new MusikStueck("Highway to Hell", "ACDC", 321));
		mss.musikStueckEinfuegen(new MusikStueck("Alabama", "XYZ", 113));
		mss.musikStueckEinfuegen(new MusikStueck("Mischigan", "XYZ", 331));
		
		MusikStueck[] nachTitel = mss.getAlleMusikStueckeNachTitel();
		
		for(MusikStueck m : nachTitel) {
			System.out.println(m);
		}
		
		System.out.println("-------------------");
		
		MusikStueck[] nachLaenge = mss.getAlleMusikStueckeNachLaenge();
		
		for(MusikStueck m : nachLaenge) {
			System.out.println(m);
		}
	}
}
