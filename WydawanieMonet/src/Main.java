public class Main {

	static int[] coins = { 1, 2, 5, 7, 10, 13, 20 };
	static int value = 55;
	static int[][] coinsSpend = new int[value + 1][];

	public static void main(String[] args) {
		int[] T = FillArray(value);
		int[][] coinsSpend = FillArray2(value, coins[coins.length - 1]);
		for (int coin : coins) {
			for (int j = 0; j <= value - coin; ++j) {
				if (T[j] < Integer.MAX_VALUE) {
					if (T[j] + 1 < T[j + coin]) {
						T[j + coin] = T[j] + 1;
						coinsSpend[j + coin] = coinsSpend[j].clone();
						coinsSpend[j + coin][coin] = coinsSpend[j + coin][coin] +1;
					}
				}

			}
		}
		System.out.println(T[value]);
		for (int i = 0; i <= 20; i++) {
			if (coinsSpend[value][i] > 0) {
				System.out.println("Moneta: " + i + " ilosc: " + coinsSpend[value][i]);
			}
		}

	}

	private static int[][] FillArray2(int value2, int max) {
		int[][] T = new int[value + 1][];
		for (int i = 0; i <= value; ++i) {
			T[i] = new int[max + 1];
			for (int j = 0; j <= max; ++j) {

				T[i][j] = 0;
			}
		}
		return T;
	}

	private static int[] FillArray(int value) {
		int[] T = new int[value + 1];
		T[0] = 0;
		for (int i = 1; i <= value; ++i) {
			T[i] = Integer.MAX_VALUE;
		}
		return T;
	}

}
