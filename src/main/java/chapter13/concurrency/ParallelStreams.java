package chapter13.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreams {

	static int total = 0;
	
	private static int seal = 0;
	private static volatile int tiger = 0;
	private static AtomicInteger lion = new AtomicInteger(0);
	
	
	public static void main(String[] args) {
		
		Stream.iterate(0, i -> i + 1).parallel().limit(100).forEach(i -> {seal++; tiger++; lion.incrementAndGet();}); // incrementing 100 times NOT adding i
		System.out.println(seal + "," + tiger + ","+ lion);
		System.out.println();
		
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
		
		
		System.out.println();
		System.out.println("Enthuware Test 15 question 31:");
		List<String> vals = Arrays.asList("a", "b", "c", "d", "e", "f", "g",
				"a", "b", "c", "d", "e", "f", "g",
				"a", "b", "c", "d", "e", "f", "g",
				"a", "b", "c", "d", "e", "f", "g");
				String join = vals.parallelStream()
				        .peek(System.out::println) //this shows how the elements are retrieved from the stream
				        .reduce("_",
				                (a, b)->{
				                    System.out.println("reducing "+a+" and "+b
				                         +" Thread: "+Thread.currentThread().getName());
				                    return a.concat(b);
				                },
				                (a, b)->{
				                    System.out.println("combining "+a+" and "+b
				                         +" Thread: "+Thread.currentThread().getName());
				                    return a.concat(b);
				                }
				        );
				System.out.println(join);
	}
	
}


