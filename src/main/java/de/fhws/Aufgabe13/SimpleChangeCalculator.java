package de.fhws.Aufgabe13;


/**
 *  Die Klasse SimpleChangeCalculator beinhaltet einen sehr einfachen
 *  Algorithmus zur Ermittlung des Wechselgelds: Es wird
 *  der gesamte Betrag in 1-Cent-Muenzen ausgegeben.
 */
public class SimpleChangeCalculator 
{
	/**
	 * Mit Hilfe des Rueckgabewerts der Methode getChange
     *
	 * wird der Muenzausgabemechanismus des Automaten gesteuert.
	 * An der Stelle 0 des Arrays steht, wie viele 1-Cent-Muenzen
	 * ausgegeben werden sollen, an der Stelle 1, wie viele 2-Cent-
	 * Muenzen usw. bis zu den 2-Euro-Muenzen an der Stelle 7.
		
	 * Der Aufrufer darf keine negativen Werte uebergeben.
	 * Der Cent-Parameter darf keinen Wert > 99 annehmen.
     */
//	public int[] getChange(int euros, int cent)
//	{
//		return new int[] {
//			euros * 100 + cent, // alles in 1-Cent-Muenzen
//			0,					// keine 2-Cent-Muenzen
//			0,					// keine 5-Cent-Muenzen
//			0,					// keine 10-Cent-Muenzen
//			0,					// keine 20-Cent-Muenzen
//			0,					// keine 50-Cent-Muenzen
//			0,					// keine 1-Euro-Muenzen
//			0					// keine 2-Euro-Muenzen
//		};
//	}
	
	public int[] getChange(int euros, int cent)
	{
		Coin[] coins = Coin.availableCoins;
		int[] result = new int[coins.length];
		int total = euros * 100 + cent;
		
		for (int i = coins.length -1; i >= 0; i--) {
			while(total >= coins[i].getValue()) {
				total -= coins[i].getValue();
				result[i]++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SimpleChangeCalculator scc = new SimpleChangeCalculator();
		scc.test();
	}
	
	/**
	 * Mit dieser Methode k�nnen Sie ihren Algorithmus testen.
	 */
	public void test()
    {
        int j = 0;

        System.out.println("\nZuerst ein simpler Fall: Es sollen 1 Euro und 70 Cent Wechselgeld zur�ckgegeben werden:");
        int[] result = getChange(1, 70);
        
        System.out.println("\nDer Automat gibt folgende Muenzen zurueck:");
        j = 0;
        for (int i=0; i < Coin.availableCoins.length; i++)
        {
          System.out.println(result[i] + " x " + Coin.availableCoins[i].getName());
          j += result[i];
        }
        System.out.println("Anzahl der M�nzen: " + j);
        
        System.out.println("\nJetzt ein bi�chen schwieriger: Es sollen 3 Euro und 88 Cent Wechselgeld zur�ckgegeben werden:");
        result = getChange(3,88);
        
        System.out.println("\nDer Automat gibt folgende Muenzen zurueck:");
        j = 0;
        for (int i=0; i < Coin.availableCoins.length; i++)
        {
            System.out.println(result[i] + " x " + Coin.availableCoins[i].getName());
            j += result[i];
        }
        System.out.println("Anzahl der M�nzen: " + j);
    }
}
