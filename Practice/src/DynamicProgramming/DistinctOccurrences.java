package DynamicProgramming;

//{ Driver Code Starts
import java.util.*;

public class DistinctOccurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.subsequenceCount(S,T));
			t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method*/
class GfG
{
 int  subsequenceCount(String S, String T)
 {
	 int sourceLength = S.length();
	 int targetLength = T.length();
	 if(targetLength > sourceLength){
	     return 0;
	 }
	 // source = row
	 // target = columns
	 int[][] dp = new int[sourceLength+1][targetLength+1];
	 //For empty source string , any non-empty target string should yield 0
	 for(int column=1;column<=targetLength;column++){
	     dp[0][column]=0;
	 }
	 //For any source string , any empty target string should yield 1
	 for(int row=0;row<=sourceLength;row++){
	     dp[row][0]=1;
	 }
	 for(int row=1;row<=sourceLength;row++){
	     for(int column=1;column <= targetLength ;column++){
	         if(S.charAt(row-1) == T.charAt(column-1)){
	             dp[row][column]=   dp[row-1][column-1]+
	                                dp[row-1][column];
	         }
	         else{
	             dp[row][column]=   dp[row-1][column];
	         }
	     }
	 }
	 return dp[sourceLength][targetLength];
 }
}