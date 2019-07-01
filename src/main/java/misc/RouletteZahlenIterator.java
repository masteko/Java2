package misc;

import java.util.Iterator;

public class RouletteZahlenIterator implements Iterator<Integer>{
	int zeroCount = 0;
	
	@Override
	public boolean hasNext() {
		return zeroCount < 3;
	}

	@Override
	public Integer next() {
		int result = (int) (Math.random() * 37);
		if (result == 0) {
			zeroCount++;
		} else {
			zeroCount = 0;
		}
		return result;
	}

}
