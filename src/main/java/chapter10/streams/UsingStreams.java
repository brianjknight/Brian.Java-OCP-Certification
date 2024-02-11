package chapter10.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStreams {
	public static void main(String[] args) {
		Stream<String> wolf = Stream.of("w","o","l","f!");
		// (a, b) -> a+b is a combiner which combines results of threads IF accumulator runs concurrently
		int length = wolf.reduce(0, (i, s) ->	i+s.length(), (a, b) -> a+b);
		System.out.println("length: " + length);
	
		List.of(1,2).stream(); // compiles but not useful
		
		Stream<String> bear1 = Stream.of("brown bear-", "grizzly-");
//		bear1.sorted(Comparator.reverseOrder()) // compiles but does nothing since a terminal operation is not called
		bear1.sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
//		Stream<String> bear2 = Stream.of("brown bear-", "grizzly-");
//		bear2.sorted(Comparator::reverseOrder).forEach(System.out::print); // does not compile method reference returns a consumer?
		
		System.out.println("\n");
		System.out.println("peeking: ");
		var numbers = new ArrayList<>();
		var letters = new ArrayList<>();
		var chars = new ArrayList<>();
		numbers.add(1);
		letters.add("a");
		letters.add("b");
		chars.add('$');
		chars.add('#');
//		Stream<List<?>> bad = Stream.of(numbers, letters, chars);
//		// peek is not intended to modify elements but does run
//		bad.peek(x -> x.remove(0)).map(List::size).forEach(System.out::print); // careful removing affects below streams
		
		System.out.println();
		Stream<List<?>> showIntermediate = Stream.of(numbers, letters, chars);
		showIntermediate.peek(e -> e.forEach(System.out::print)).peek(e -> System.out.print(e + "!")).map(List::size).forEach(System.out::println);
		// performs each pipeline to termination in turn
			// first peek prints each element of each element/list, second peek prints the element/list, converts and prints list size
		
		System.out.println();
		var lower = List.of('a','b','c');
		var upper = List.of('A','B','C');
//		Stream<List<?>> lowerStream = Stream.of(lower);
//		Stream<List<?>> upperStream = Stream.of(upper);
//		Stream<List<?>> lowerAndUpper = Stream.concat(lowerStream, upperStream);
		var listOfLists = List.of(lower, upper);
		List<?> result = listOfLists.stream()
									.peek(System.out::print) // intermediate step prints each list > [a,b,c] continue [A,B,C]
									.flatMap(list -> list.stream()) // intermediate step flattening map
									.peek(System.out::print) // intermediate step prints each element of a list > abc continues ABC
									.toList() // terminal step creates single/flat map
									.stream() // stream the flattened map
									.peek(System.out::print) // intermediate step prints each element of flattend list > abcABC
									.toList()
									.stream()
									.map(Character::toUpperCase)
									.peek(System.out::print) // prints > ABCABC
									.collect(Collectors.toList()) // terminal step
									.stream()
									.distinct()
									.peek(e -> System.out.print(" " + e + " ")) // prints >  A  B  C
									.toList() // terminal step 
									.stream()
									.skip(1)
									.peek(System.out::print) // prints > BC
									.toList() // terminal step 
									.stream()
									.limit(1)
									.peek(e -> System.out.print(" " + e)) // prints > B
									.toList(); // terminal operation returns unchanged flattened map from previous pipeline
		System.out.println();
		System.out.println("result: " + result); // result is [B]
		
		System.out.println();
		var names = List.of("Zoe","William", "Joe", "Michael", "Cat", "Abe");
		names.stream()
			 .filter(n -> n.length()==3)
			 .peek(System.out::println) // prints all 3 letter names
			 .sorted()  // stateful (not terminating) operation requires all elements to be filtered prior to continuing pipeline
			 // pipeline continues with [Abe, Cat, Joe, Zoe]
			 .limit(2)
			 .forEach(System.out::println);
		System.out.println();
		
//		Stream<Integer> infinite = Stream.iterate(1, n -> n++);
//		System.out.println(infinite.count());
		
//		Optional<String> x = names.stream().max(); // required Comparator param

		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", String::concat);
		System.out.println(word); // wolf
		System.out.println();
		
		Stream<String> xyz = Stream.of("w", "o", "l", "f");
		Optional<String> optStr = xyz.reduce(String::concat);
		System.out.println(optStr.orElse("stream was empty"));
	}
	
}


