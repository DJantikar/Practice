package DynamicProgramming;

public class CountNumberOfBinaryWithoutConsecutiveOnes {
	public static void main(String[] args) {
		int n=3;
		System.out.println("countWithDP "+countWithDP(n));
		System.out.println("countWithoutDP "+countWithoutDP(n));
	}
	//Time : O(n) Space : O(n)
	private static int countWithDP(int n) {		
		if(n==1){
			return 2;
		}
		if(n==2){
			return 3;
		}
		int[] dp = new int[n+1];
		dp[1]=2;
		dp[2]=3;
		for(int i=3;i<=n;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	//Time : O(n) Space : O(1)
	private static int countWithoutDP(int n){
		if(n==1){
			return 2;
		}
		if(n==2){
			return 3;
		}
		int dp1=2;
		int dp2=3;
		for(int i=3;i<=n;i++){
			int tmp = dp2;
			dp2 = dp1+dp2;
			dp1=dp2;
		}
		return dp2;
	}
	

}
