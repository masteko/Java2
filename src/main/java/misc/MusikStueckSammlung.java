package misc;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

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
//		return sammlung.values().stream().sorted(new VergleicheMusikStueckTitel()).toArray(MusikStueck[]::new);
//		Arrays.sort(result, Comparator.comparing(MusikStueck::getInterpret).thenComparing(MusikStueck::getTitel).thenComparingInt(MusikStueck::getLaenge));
//		return result;
		return sammlung.values().stream().sorted(Comparator.comparing(MusikStueck::getInterpret)).toArray(MusikStueck[]::new);
	}
	
	public MusikStueck[] getAlleMusikStueckeNachLaenge() {
		return sammlung.values().stream().sorted((a, b) -> a.laenge - b.laenge).toArray(MusikStueck[]::new);
//		return sammlung.values().stream().sorted(new VergleicheMusikStuckLaenge()).toArray(MusikStueck[]::new);
	}
	
	public static void main(String[] args) {
		MusikStueckSammlung mss = new MusikStueckSammlung();
		try {
			mss.musikStueckEinfuegen(new MusikStueck("Thriller", "Michael", 123));
			mss.musikStueckEinfuegen(new MusikStueck("Highway to Hell", "ACDC", 321));
			mss.musikStueckEinfuegen(new MusikStueck("Alabama", "XYZ", 113));
			mss.musikStueckEinfuegen(new MusikStueck("Alabama", "s", 113));
			mss.musikStueckEinfuegen(new MusikStueck("Mischigan", "XYZ", 331));			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			GZIPOutputStream output = new GZIPOutputStream(System.out);
			output.write("hallo welt".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
