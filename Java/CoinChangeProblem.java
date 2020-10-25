
public class CoinChangeProblem {
	
	public static int findMinCoins(int[] S, int N)
	{
		// T[i] stores minimum number of coins needed to get total of i
		int[] T = new int[N + 1];

		for (int i = 1; i <= N; i++)
		{
			// initialize minimum number of coins needed to infinity
			T[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;

			// do for each coin
			for (int c: S)
			{
				// check if index doesn't become negative by including
				// current coin c
				if (i - c >= 0) {
					res = T[i - c];
				}

				// if total can be reached by including current coin c,
				// update minimum number of coins needed T[i]
				if (res != Integer.MAX_VALUE) {
					T[i] = Integer.min(T[i], res + 1);
				}
			}
		}

		// T[N] stores the minimum number of coins needed to get total of N
		return T[N];
	}
	public static void main(String[] args) {
		
		int[] S = { 1, 2, 3, 4 };

		// Total Change required
		int N = 15;

		int coins = findMinCoins(S, N);
		if (coins != Integer.MAX_VALUE) {
			System.out.print("Minimum number of coins required to get desired change is "
				+ coins);
		}

	}

}
