package DynamicProgramming;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
 int x;
 int y;
 
 public Pair(int a, int b)
 {
     x = a;
     y = b;
 }
}

public class MaxLengthChainFinder
{
 public static void main (String[] args) {
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     
     while(t-- > 0)
     {
         int n = sc.nextInt();
         Pair pr[] = new Pair[n];
         int arr[] = new int[2*n];
         for(int i = 0; i < 2*n; i++)
         {
            arr[i] = sc.nextInt();
         }
         for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
         {
             pr[j] = new Pair(arr[i], arr[i+1]);
         }
         MaxLengthChain g = new MaxLengthChain();
         System.out.println(g.maxChainLength(pr, n));
     }
 }
}
//} Driver Code Ends



class CompareByLast implements Comparator<Pair>
{
public int compare(Pair a, Pair b)
 {
     return a.y - b.y;
 }
}

class MaxLengthChain
{
 int maxChainLength(Pair arr[], int n)
 {
    Arrays.sort(arr, new CompareByLast());
    Arrays.asList(arr).forEach(pair->System.out.println("x :"+pair.x+" , y "+pair.y));
    int dp[] = new int[n];
    Arrays.fill(dp, 1);
    int maxLength = 1;
    Set<Pair> result = new HashSet<Pair>();
    for(int pivot=1;pivot<n;pivot++){
    	Pair pivotPair = arr[pivot];
    	for(int curr=0;curr<pivot;curr++){
    		Pair currPair = arr[curr];
    		if(currPair.y < pivotPair.x && dp[pivot]<(1+dp[curr])){
    			dp[pivot]=1+dp[curr];
    			if(maxLength<dp[pivot]){
    				result.add(currPair);
    				result.add(pivotPair);
    				maxLength=dp[pivot];
    			}
    		}
    	}
    }
    return maxLength;
 }
}
