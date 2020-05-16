package DynamicProgramming;

import java.lang.*;
import java.io.*;
import java.util.*;
public class MinJumps
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        int numOfTestCases = t;

        for(int p = 0;p<numOfTestCases;p++){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            
            DynamicProgramming obj = new DynamicProgramming();
            System.out.println(obj.minimumJumps(arr, size));
        }
	 }
	
}
// } Driver Code Ends




class DynamicProgramming{
    
    // function to find minimum number of jumps to reach end of the array
    public static int minimumJumps(int arr[], int n){
        if(n==1)
            return 0;
        int jumps=1;
        int ladder = arr[0];
        int stairs = arr[0];
        for(int level=1;level<n;level++){
            if(stairs==0)
                return -1;
            if(level==n-1)
                return jumps;
            if(level+arr[level] > ladder){
                ladder = level+arr[level] ;
            }
            stairs--;
            if(stairs == 0){
                jumps++;
                stairs = ladder-level;
            }
        }
        return jumps;
        
    }
}
