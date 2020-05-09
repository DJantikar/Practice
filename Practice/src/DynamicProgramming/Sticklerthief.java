package DynamicProgramming;
import java.util.*;
import java.io.*;
/*
 * Time Complexity : O(n)
 * Space Complexity = O(1)
 */
class Sticklerthief
 {
	public static void main (String[] args)
	 {
	   
	  Scanner sc = new Scanner(System.in);
	  int t = sc.nextInt();
	  while(t-- > 0){
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      System.out.println(new solve().FindMaxSum(arr, n));
	 }
   }
}// } Driver Code Ends


class solve{
    // Function to return maximum of sum without adjacent elements
    public int FindMaxSum(int arr[], int n){
        if(n==0)
            return 0;
        if(n==1)
            return arr[0];
        if(n==2)
            return Math.max(arr[0],arr[1]);
        int val1 = arr[0];
        int maxValue = Math.max(arr[0],arr[1]);
        int val2 = maxValue;
        for(int i=2;i<n;i++){
            maxValue = Math.max(val2,arr[i]+val1);
            val1 = val2;
            val2=maxValue;
        }
        return maxValue;
    }
}