package misc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.glassfish.jersey.internal.guava.Lists;

public class Test2  extends Test{
	
	Set<String> testSet;
	Map<String, String> testMap;

	public Test2(String name, String plz) {
		super(name, plz);
		testMap = new HashMap<>();
	}
	
	public static void main(String[] args) {
//		Test2 t = new Test2("name", "988");
//		String[] arr = {"asdf", "asdf"};
//		List<String> list = new ArrayList<>();
//		t.testMap.put("test", "asdf");
//		t.testMap.put("asdf", "asdf");
//		t.testMap.put("rass", "asdf");
//		t.testMap.put("tsssest", "asdf");
//		t.testMap.put("asd", "asdf");
//		t.testMap.put("ff", "asdf");
//		t.testMap.put("xx", "asdf");
//		t.testSet = t.testMap.keySet();
//		list.addAll(t.testSet);
//		System.out.println(Arrays.asList("asdf", "asdf"));
//		System.out.println(Arrays.asList(arr));
//		System.out.println(List.of(arr));
//		System.out.println(List.of("asdf", "asdfsss"));
		
//		Thread t1 = new Thread(() -> System.out.println("Hallo Thread"));
//		t1.start();
		
		File f = new File("asdf");
		Optional<String> opt = Optional.ofNullable(null);
		
		System.out.println(opt.isPresent());
		
		try {
			InputStream is = new FileInputStream(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();	
			
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bas = new BufferedOutputStream(System.out);
			
			OutputStreamWriter osw = new OutputStreamWriter(System.out);
			BufferedWriter bw = new BufferedWriter(osw);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
