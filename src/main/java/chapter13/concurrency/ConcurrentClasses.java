package chapter13.concurrency;

import java.util.List;

public class ConcurrentClasses {

	static int total = 0;
	
	public static void main(String[] args) {
		
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("", (s1,c) -> s1 + c, (s2,s3) -> s2 + s3));

		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("", (s1,c) -> s1 + c)); // in theory lack of combiner can produces inconsistent results
				
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("X", (s1,c) -> s1 + c));
		
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("X", (s1,c) -> s1 + c, (s2,s3) -> s2 + s3));
				
		System.out.println(List.of(1,2,3,4,5,6) // in theory lack of combiner can produces inconsistent results
				.parallelStream()
				.reduce(0, (a,b) -> (a-b))); // probably need a much larger list for this to happen
	}
	
}


