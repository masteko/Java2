package misc;

import java.util.Iterator;

public class SquareIterator implements Iterator<Integer>{
	long current = 1;
	long next = 1;
	@Override
	public boolean hasNext() {
		return next * next <= Integer.MAX_VALUE;
	}

	@Override
	public Integer next() {
		current = next;
		next++;
		return (int) (current * current);
	}
	
	public static void main(String[] args) {
		Iterator<Integer> iter = new SquareIterator();

		while(iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
		
	}

}
