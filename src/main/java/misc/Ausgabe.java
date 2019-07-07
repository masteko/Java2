package misc;

public class Ausgabe {
	public static void main(String[] args) {
		int count = 0;
		
		Thread t1 = new Thread(() -> {
			System.out.println("hallo");
			if (count <= 50) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("Ciao");
			try {
				Thread.sleep((int) (Math.random() * 1000) + 500);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		});
		
		Thread t3 = new Thread("test") {
			boolean exit = false;
			
			@Override
			public void run() {
				while(!exit) {
					System.out.println(this.getName());
					if (count <= 50) {
						try {
							sleep(1500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
					}					
				}
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		
		
		try {
			t1.join();
			t2.join();	
		} catch (Exception e2) {
		}
		
		
	}
}
