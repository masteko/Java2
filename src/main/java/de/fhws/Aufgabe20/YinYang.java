package de.fhws.Aufgabe20;

public class YinYang {

	public static void main(String[] args) {
		Thread t1 = new Thread("Yang") {
			public void run() {
				while(true) {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName());					
				}
			};
		};
		Thread t2 = new Thread("Yin") {
			public void run() {
				while(true) {
					System.out.println(this.getName());
					
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		
		t1.start();
		t2.start();

	}

}
