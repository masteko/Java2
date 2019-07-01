package misc;

import java.util.Comparator;

public class VergleicheMusikStuckLaenge implements Comparator<MusikStueck>{
	@Override
	public int compare(MusikStueck o1, MusikStueck o2) {
		return o1.laenge - o2.laenge;
	}
}
