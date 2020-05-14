package DynamicProgramming;


	// { Driver Code Starts


	import java.util.*;
	import java.lang.*;
	import java.io.*;
//Time : O(n2) Space : O(n)
	public class LongestIncreasingSubsequence {
		public static void main (String[] args) {
		    Scanner in=new Scanner(System.in);
		    int t=in.nextInt();
		    while(t-- > 0)
		    {
		        int n=in.nextInt();
		        int arr[]=new int[n];
		        for(int i = 0;i<n;i++){
		            arr[i] = in.nextInt();
		        }
		        
		        LongestSubsequence obj = new LongestSubsequence();
		        
		        System.out.println(obj.longestSubsequence(n, arr));
		                
		    }
		}
	}// } Driver Code Ends



	class LongestSubsequence{
	    
	    // function to find longest increasing subsequence
	    long longestSubsequence(int n, int arr[]){
	        
	        int start = 0;
	        int end = 0;
	        int maxLength = 1;
	        int dp[] = new int[n];
	        Arrays.fill(dp,1);
	        for(int pivot=1;pivot<n;pivot++){
	            for(int curr=0;curr<pivot;curr++){
	                if(arr[curr]<=arr[pivot] && dp[pivot]<(1+dp[curr])){
	                    dp[pivot]=1+dp[curr];
	                    if(maxLength<dp[pivot]){
	                        start=curr;
	                        end=pivot;
	                        maxLength=dp[pivot];
	                    }
	                }
	            }
	        }

	        return maxLength;
	    }
	    
	}
