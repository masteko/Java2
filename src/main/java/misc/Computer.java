package misc;

public class Computer {
	long seriennummer;
	int kernAnzahl;
	String hersteller;
	Betriebssystem betriebssystem;
	
	public static void main(String[] args) {
		Computer c = new ComputerBuilder(12323323, "Lenovo").withKernAnzahl(20).build();
		c.ausfuehren(() -> System.out.println("Hallo Welt!"));
	}
	
	private Computer(long a, int b, String c, Betriebssystem d) {
		seriennummer = a;
		kernAnzahl = b;
		hersteller = c;
		betriebssystem = d;
	}
	
	public void ausfuehren(Programm programm) {
		for (int i = 0; i < kernAnzahl; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						if (betriebssystem.equals(Betriebssystem.WINDOWS_XP) ) {
							sleep(5000);
						} else if (betriebssystem.equals(Betriebssystem.WINDOWS_10)) {
							sleep(100);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					programm.ausfuehren();
				}
			};
			t.start();
		}
	}
	
	public static class ComputerBuilder {
		long seriennummer;
		int kernAnzahl;
		String hersteller;
		Betriebssystem betriebssystem;
		
		public ComputerBuilder(long seriennummer, String hersteller) {
			this.seriennummer = seriennummer;
			this.kernAnzahl = 1;
			this.hersteller = hersteller;
			this.betriebssystem = Betriebssystem.WINDOWS_10;
		}
		
		public ComputerBuilder withKernAnzahl(int kernAnzahl) {
			this.kernAnzahl = kernAnzahl;
			return this;
		}
		
		public ComputerBuilder withBetriebssystem(Betriebssystem betriebssystem) {
			this.betriebssystem = betriebssystem;
			return this;
		}
		
		public Computer build() {
			return new Computer(seriennummer, kernAnzahl, hersteller, betriebssystem);
		}
	}
}
