package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Haus implements Comparable<Haus>, Iterable<Raum> {
	List<Stockwerk> stockwerke;
	
	public Haus() {};
	
	public static void main(String[] args) {
		Haus h1 = new Haus(List.of(
					new Stockwerk(List.of(
							new Raum(50),
							new Raum(100))), 
					new Stockwerk(List.of(
							new Raum(300), 
							new Raum(10)))));
		
		Haus h2 = new Haus(List.of(
				new Stockwerk(List.of(
						new Raum(50),
						new Raum(1000)))));
		
		List<Haus> haeuser = new ArrayList<>();
		haeuser.add(h2);
		haeuser.add(h1);
//		haeuser.stream().sorted().forEach(System.out::println);
		
		h1.forEach(System.out::println);
		h2.forEach(System.out::println);
		
//		System.out.println(haeuser);
//		Collections.sort(haeuser);
//		System.out.println(haeuser);
	}
	
	public Haus(List<Stockwerk> stockwerke) {
		this.stockwerke = stockwerke;
	}
	
	@Override
	public int compareTo(Haus o) {
		return getQuadratmeter() - o.getQuadratmeter();
	}
	
	public int getQuadratmeter() {
		return this.stockwerke.stream().mapToInt(Stockwerk::getQuadratmeter).sum();
	}

	@Override
	public Iterator<Raum> iterator() {
		return new Iterator<Raum>() {
			int index = 0;
			Raum[] raeume = stockwerke.stream().flatMap(st -> st.getRaeume().stream()).toArray(Raum[]::new);

			@Override
			public boolean hasNext() {
				return index < raeume.length;
			}

			@Override
			public Raum next() {
				return raeume[index++];
			}
		};
	}

}
