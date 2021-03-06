package DynamicProgramming;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class FrogsJump
{
 public static void main(String args[])
 {
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     
     while(t-- > 0)
     {
         int n = sc.nextInt();
         System.out.println(new Hops().countWaysOrderDoesNotMatter(n));
         
     }
 }
}
//} Driver Code Ends


//User function Template for Java

/*Complexity Analysis:

Time Complexity: O(n).
Only one traversal of the array is needed. So Time Complexity is O(n).
Space Complexity: O(n).
To store the values in a DP, n extra space is needed.*/
class Hops
{
 static long countWays(int n)
 {
     long modulo=1000000007;
     if(n==1 || n==2)
         return n;
     if(n == 3)
         return 4;
     long[] dp = new long[n];
     dp[0]=1;
     dp[1]=2;
     dp[2]=4;
     for(int i=3;i<n;i++){
         dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%modulo;
     }
     return dp[n-1]%modulo;
 }
//function to find number of ways 
 static Long countWaysOrderDoesNotMatter(int m){
     
    if(m==1 || m==2){
         return (long)m;
     }
     long dp[] = new long[m+1];
     dp[1]=1;
     dp[2]=2;
     Arrays.fill(dp,1);
     dp[0]=0;
     for(int step=3;step<=m;step++){
      dp[step]=1+dp[step-2];
     }
     return dp[m];
 }
 
}

