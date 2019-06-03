package misc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayTest {
	
	List<Integer> list;
	
	@BeforeEach
	void init() {
		list = new ArrayList<>();
//		list = Collections.synchronizedList(list);
	}

	@Test
	void test() throws InterruptedException {
		int amount = 10000;
		ArrayThread t1 = new ArrayThread(amount);
		ArrayThread t2 = new ArrayThread(amount);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		assertEquals(amount * 2, list.size());
	}
	
	private class ArrayThread extends Thread {
		int amount;
		
		public ArrayThread(int amount) {
			this.amount = amount;
		}
		
		
		@Override
		public void run() {
			while(amount > 0) {
				list.add(amount--);
			}
		}
	}

}
