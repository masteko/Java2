package misc;

import java.io.ObjectOutputStream.PutField;
import java.util.Arrays;
import java.util.HashMap;

import com.sun.tools.javac.util.List;

public class MapReduce {
	static String msg = "Die Burg wurde im 11. Jahrhundert von den Herren von Michelstein erbaut und wird 1102 erstmals erwähnt. In diesem Jahr wird ein Reginhard von Michelstein als Zeuge bei einer Schenkung genannt. 1305 wird mit Agnes von Michelstein diese Familie letztmals erwähnt, die Burg trug den Namen Michelstein noch bis ins 16. Jahrhundert. Die Burg wird 1356 angeblich durch ein Erdbeben teilweise zerstört. 1377 zerstört die Reichsstadt Rottweil im ersten großen Städtekrieg Burg Michelstein und das Dorf Bubsheim, wobei Mauerreste (Bruchstein- und Buckelquadermauerwerk) und ein Teil des Bergfrieds erhalten bleiben.\r\n" + 
			"\r\n" + "1483 wird Bertold von Balgheim durch Herzog Sigmund von Österreich mit der Ruine belehnt. 1489 geht das Lehen an die Stain von Steinegg über. Von 1536 bis 1792 befindet sich das Lehen im Besitz der Ifflinger von Granegg, von denen Burg Michelstein dann auch seinen neuen Namen erhielt. 1792 verkauft Karl-Alexander seinen Fridinger Besitz mit der Burgruine Michelstein um 95000 Gulden an Emanuel und Michael Levi aus Hechingen. 1831 wird die Ruine durch Karl von Ifflinger zurückerworben.\r\n" + 
			"\r\n" + "1923 ist die Turmruine im Eigentum der Katholischen Kirchenpflege in Rottweil und geht 1931 an den Schwäbischen Albverein, der die Sicherung der Ruine übernimmt. ";
	
	public static void main(String[] args) {	
		msg.lines().parallel()
			.flatMap(item -> Arrays.asList(item.split(" ")).stream())
			.filter(item -> item.length() != 0)
			.map(item -> {
				HashMap<String, Integer> map = new HashMap<>();
				map.put(item, 1);
				return map;
			})
			.reduce((a, b) -> {
				String s = b.keySet().toArray()[0].toString();
				if (s != null) {
					int i = a.get(s);
					if (a.get(s) != null) {
						a.put(s, ++i);
					}
					return a;					
				} else return null;
			})
			.ifPresent(System.out::println);
	}
}
