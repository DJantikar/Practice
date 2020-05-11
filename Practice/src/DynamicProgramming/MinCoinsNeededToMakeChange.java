package DynamicProgramming;

//{ Driver Code Starts

//Initial Template for Java

import java.io.*;
import java.util.*;
//Time : O(numberOfCoing * Value) space = O(value)
public class MinCoinsNeededToMakeChange {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    int value=sc.nextInt();
		    int numberOfCoins=sc.nextInt();
		    int coins[]=new int[numberOfCoins];
		    
		    for(int i=0;i<numberOfCoins;i++)
		    {
		        int x=sc.nextInt();
		        coins[i]=x;
		    }
		    Geeks obj=new Geeks();
		    long answer=obj.minimumNumberOfCoins(coins,numberOfCoins,value);
		    System.out.println(answer==Integer.MAX_VALUE?"Not Possible":answer);
		}
	}
}


// } Driver Code Ends






class Geeks
{
 //Complete this function
 public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
 {
     long minimumNumberOfCoinsRequired[]=new long[value+1];
     //The above array holds the minimum number of coins for every amount from 0 to value
     Arrays.fill(minimumNumberOfCoinsRequired,Integer.MAX_VALUE);
     //We fill all array with inifinty as intially we need infinite coins to make the value
     minimumNumberOfCoinsRequired[0]=0;
     for(int coin:coins)//Iterating over each coin
     {
         for(int i=1;i<value+1;i++)
         {
             if(i>=coin)//No use in checking for values that are smaller than the current coin
             {
                 //Your code here
                 /*
                 The minimum number of coins required to make current i value can be found
                 by taking seeeing which is minimum : 
                 (current coins required to form i value)
                 or
                 (1+ coins required to form i-coin value)
                 */
                 int valueRemainingAfterCoin = i-coin;
                 long minCoinsNeededForRemainder = minimumNumberOfCoinsRequired[valueRemainingAfterCoin];
                 minimumNumberOfCoinsRequired[i]=Math.min(1+minCoinsNeededForRemainder,minimumNumberOfCoinsRequired[i]);
             }
         }
     }
     return minimumNumberOfCoinsRequired[value];
 }
}


