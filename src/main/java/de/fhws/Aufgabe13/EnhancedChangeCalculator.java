package de.fhws.Aufgabe13;

public class EnhancedChangeCalculator extends SimpleChangeCalculator {
	
	@Override
	public int[] getChange(int euros, int cent) {
		Coin[] coins = Coin.availableCoins;
		Coin coin;
		int[] result = new int[coins.length];
		int change = euros * 100 + cent;

		for (int i = coins.length - 1; i >= 0; i--) {
			coin = coins[i];
			while (change >= coin.getValue()) {
				result[i]++;
				change -= coin.getValue();
			}
		}
		
		return result;
	}
}
