package DynamicProgramming;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

//Time : (number of segments * target length) Space : O(targetLength)
public class MaximizeCutSegments
{
 public static void main(String args[])throws IOException
 {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(read.readLine());
     
     while(t-- > 0)
     {
         int n = Integer.parseInt(read.readLine().trim());
         
         String str[] = read.readLine().trim().split(" ");
         
         int x = Integer.parseInt(str[0]);
         int y = Integer.parseInt(str[1]);
         int z = Integer.parseInt(str[2]);
         
         System.out.println(new Solution().maximizeCuts(n, x, y, z));
     }
 }
}
//} Driver Code Ends


//User function Template for Java


class Solution
{
 public int maximizeCuts(int n, int x, int y, int z)
 {
    int[] dp = new int[n+1];
    int[] subLengths = {x,y,z};
    Arrays.fill(dp,Integer.MIN_VALUE);
    dp[0] = 0;
    for(int subLength : subLengths){
        for(int targetLength = 1 ; targetLength<=n;targetLength++){
            if(targetLength>=subLength){
                int remainingLength = targetLength-subLength;
                int segmentsIncludingCoin = dp[remainingLength]+1;
                int segmentsExcludingCoin = dp[targetLength];
                int maxSegmentsPossible = Math.max(segmentsIncludingCoin,segmentsExcludingCoin);
                dp[targetLength] = maxSegmentsPossible;
            }
        }
    }
    return dp[n] < 0 ? 0 : dp[n];
 }
}
