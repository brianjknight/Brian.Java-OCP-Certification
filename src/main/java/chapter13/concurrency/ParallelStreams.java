package chapter13.concurrency;

import java.util.List;

public class ParallelStreams {

	static int total = 0;
	
	public static void main(String[] args) {
		
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("", (id,c) -> id + c, (s1,s2) -> s1 + s2));

		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("", (id,c) -> id + c)); // in theory lack of combiner can produces inconsistent results
												// combiner can be omitted when intermediate data types are the same?
				
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("X", (id,c) -> id + c));
		
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream() // in this instance a new stream is created for each element SO each one gets the identity X
				.reduce("X", (id,c) -> id + c, (s1,s2) -> s1 + s2));
				
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.stream()
				.reduce("X", (id,c) -> id + c, (s1,s2) -> s1 + s2));
		
		System.out.println(List.of(1,2,3,4,5,6) // in theory lack of combiner can produces inconsistent results
				.parallelStream()
				.reduce(0, (a,b) -> (a-b))); // probably need a much larger list for this to happen
				// 0-1-2-3-4-5-6 = -21 not parallel
				// could be -1, -2, -3, -4, -5, -6 -> -1-(-2)=1, -3-(-4)=1, -5-(-6)=1 -> 1-1-1...
	}
	
}


