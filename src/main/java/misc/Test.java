package misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test implements TestInt{
	private String name;
	String plz;
	
	public Test() {
		System.out.println(stringName);
	}
	
	public Test(String name, String plz) {
		this.name = name;
		this.plz = plz;
	}
	
	public void testMethode() {
		throw new Error();
	}
	
	class Test3 {
		public Test3() {
			System.out.println(name);
		}
	}
	
	public static double berechneProzent(int a, int b) {
		if (a <= 0 || b <= 0) return -1;
		return a * (b / 100d);
	}
	
	public static void main(String[] args) throws IOException {
//		Test t = new Test();
//		Map<String, String> t3 = new HashMap<>();
//		
//		t3.put("test", "hallo");
//		Test3 test = new Test("hello", "hello").new Test3();
//
		System.out.println(berechneProzent(30, -5));
		
	}
}
