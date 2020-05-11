package DynamicProgramming;

//{ Driver Code Starts
import java.util.*;
import java.io.*;

// Time an dSpace O(n2)
public class KnapsackZeroOrOne
{
 public static void main(String args[])throws IOException
 {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(read.readLine());
     
     while(t-- > 0)
     {
         int n = Integer.parseInt(read.readLine());
         int w = Integer.parseInt(read.readLine());
         
         int val[] = new int[n];
         int wt[] = new int[n];
         
         String st[] = read.readLine().trim().split("\\s+");
         for(int i = 0; i < n; i++)
           val[i] = Integer.parseInt(st[i]);
          
         String s[] = read.readLine().trim().split("\\s+"); 
         for(int i = 0; i < n; i++)
           wt[i] = Integer.parseInt(s[i]);
           
         System.out.println(new Knapsack().knapSack(w, wt, val, n));
     }
 }
}



//} Driver Code Ends


class Knapsack 
{ 
 // Returns the maximum value that can be put in a knapsack of capacity W 
 static int knapSack(int W, int wt[], int val[], int n) 
 { 
      int dp[][] = new int[n+1][W+1];
      Arrays.fill(dp[0], 0);
      for(int row=1;row<=n;row++){
          for(int column=0;column<=W;column++){
              int targetWeight = column;
              if(wt[row-1]>targetWeight){
                  dp[row][column]=dp[row-1][column];
              }
              else{
                  int remainingWeight = column-wt[row-1];
                  int remainingWeightVal=0;
                  if(remainingWeight>=0){
                      remainingWeightVal=dp[row-1][remainingWeight];
                  }
                  int inclusionWeightVal = remainingWeightVal+val[row-1];
                  int exclusionWeightVal = dp[row-1][column];
                  dp[row][column]=Math.max(inclusionWeightVal,exclusionWeightVal);
              }
          }
      }
      return dp[n][W];
 } 
}



