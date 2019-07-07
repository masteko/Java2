package misc;

public class Kugelvolumen {
	public static double berechneKugelvolumen(double radius) {
		if (radius <= 0) throw new RuntimeException("Ungueltiger Radius");
		return 4d/3 * Math.PI*radius*radius*radius;
	}
}
