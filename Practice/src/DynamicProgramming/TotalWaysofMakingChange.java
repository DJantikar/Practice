package DynamicProgramming;

import java.util.Arrays;

//Time : (numberOfCoins*Value) Space : O(value)

public class TotalWaysofMakingChange {
	public static void main(String[] args) {
		int[] coins = {2,5,3,6};
		int n= 10;
		int[] dp = new int[n+1];
		dp[0]=1;
		for(int coin : coins){
			for(int targetValue=1;targetValue<=n;targetValue++){
				if(targetValue>=coin){
					int waysIfCoinIncluded = dp[targetValue-coin];
					int waysIfCoinExcluded = dp[targetValue];
					int totalWays = waysIfCoinIncluded + waysIfCoinExcluded;
					dp[targetValue]= totalWays;
				}
			}
		}
		System.out.print(dp[n]+ ": Total number of ways to make change for "+n+" using ");
		Arrays.stream(coins).forEach(x->System.out.print(x+" "));
		
		
	}
}
