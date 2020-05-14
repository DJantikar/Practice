package DynamicProgramming;

import java.util.regex.Pattern;


//{ Driver Code Starts
import java.util.*;

public class WildCardPatternMatching 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			System.out.println(wildCard(pat,text));
			t--;
		}
	}
	static int wildCard(String pattern, String str)
	 {
		 int patternLength=pattern.length();
		 int inputStringLength = str.length();
		 //removing continuous **
		 boolean dp[][] = new boolean[inputStringLength+1][patternLength+1];
		 dp[0][0]=true;		 
		 for(int inputCharIndex = 1; inputCharIndex<=inputStringLength ; inputCharIndex++){
			 for(int patternCharIndex=1;patternCharIndex<=patternLength;patternCharIndex++){
				 if((str.charAt(inputCharIndex-1) == pattern.charAt(patternCharIndex-1)) ||
					 '?' == pattern.charAt(patternCharIndex-1)){
					 dp[inputCharIndex][patternCharIndex] = dp[inputCharIndex-1][patternCharIndex-1];
				 }
				 else if('*' == pattern.charAt(patternCharIndex-1)){
					 dp[inputCharIndex][patternCharIndex] = dp[inputCharIndex][patternCharIndex-1] || dp[inputCharIndex-1][patternCharIndex];
				 }
			 }
		 }
	     return dp[inputStringLength][patternLength] ? 1 : 0;
	 }
}// } Driver Code Ends

