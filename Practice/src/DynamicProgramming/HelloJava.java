package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByLengthComparator implements Comparator<String>{

	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}	
}

public class HelloJava {
	public static void main(String[] args) {
		/*Input : Hi World Java
		Output : Hi Java World*/
		List<String> input = new ArrayList<String>();
		input.add("Hi");
		input.add("World");
		input.add("Java");
		System.out.println("Before : ");
		input.stream().forEach(x->System.out.print(x+ " "));
		Collections.sort(input,new SortByLengthComparator());
		System.out.println("\nAfter : ");
		input.stream().forEach(x->System.out.print(x+ " "));
		
		
	}
}
