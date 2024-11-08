package chapter10.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStreams {
	
	public static void main(String[] args) {
		
		var streamQR = Stream.iterate("", (q) -> q + "1");
		System.out.println(streamQR.limit(3).map(r -> r + "2").toList()); // seed "" is first element > map "" + 2 > "1" > "1" + 2 
		System.out.println();
		
		Stream<String> empty = Stream.of();
		
		Stream<String> wolf = Stream.of("w","o","l","f!");
		// (a, b) -> a+b is a combiner which combines results of threads IF accumulator runs concurrently
		int length = wolf.reduce(0, (i, s) ->	i+s.length(), (a, b) -> a+b);
		System.out.println("length: " + length);
	
		List.of(1,2).stream(); // compiles but returns a Stream but does nothing with it.
		
		Stream<String> bear1 = Stream.of("brown bear-", "grizzly-");
//		bear1.sorted(Comparator.reverseOrder()); // compiles but does nothing since a terminal operation is not called
		bear1.sorted(Comparator.reverseOrder()).forEach(System.out::print);
//		bear1.forEach(System.out::print); // bear1 already operated on or closed
		
//		Stream<String> bear2 = Stream.of("brown bear-", "grizzly-");
//		bear2.sorted(Comparator::reverseOrder).forEach(System.out::print); // does not compile; 
		// equivalent to () -> Comparator.reverseOrder() which is Supplier<Comparator> NOT a Comparator 
		
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
		Stream<List<?>> bbb = Stream.of(numbers, letters, chars);
//		// peek is not intended to modify elements but does run
//		bbb.peek(x -> x.remove(0)).map(List::size).forEach(System.out::print); // careful removing affects below streams	
		
		Stream<List<?>> showIntermediate = Stream.of(numbers, letters, chars);
		showIntermediate.peek(e -> e.forEach(System.out::print)) // e is list then calling forEach on the list
						.peek(e -> System.out.print(e + "!")) // e is a List
						.map(List::size)
						.forEach(System.out::println);
		// performs each pipeline step to termination in turn with no stateful operations
			// first peek prints each element of each element/list, second peek prints the element/list, converts and prints list size
		
		System.out.println();
		var lower = List.of('a','b','c');
		var upper = List.of('A','B','C');
//		Stream<List<?>> lowerStream = Stream.of(lower);
//		Stream<List<?>> upperStream = Stream.of(upper);
//		Stream<List<?>> lowerAndUpper = Stream.concat(lowerStream, upperStream);
		var listOfLists = List.of(lower, upper);
		Stream<List<Character>> streamOfLists = listOfLists.stream();
		List<?> result = streamOfLists
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
		System.out.println();
		
		Stream<String> s = Stream.of("monkey", "ape", "bonobo");
		Comparator<String> sc = Comparator.comparing(String::length);
//		Optional<String> min = s.min((s1, s2) -> s1.length()- s2.length());
//		Optional<String> min = s.min(sc);
		Optional<String> min = s.min(Comparator.comparing(String::length));
		System.out.println(min.orElse("empty"));
		System.out.println();
		
		
		List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
		System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)-> a>b ? a : b)); //1
		System.out.println(ls.stream().max(Integer::max).get()); //2 Integer.max(3,4) returns 4, however this is a comparator of elements a,b > 4 is a positive result i.e. 3 > 4
		System.out.println(ls.stream().max(Integer::compare).get()); //3 Integer.compare(3,4) returns -i; therefore 3<4 or 4>3 and keeps max int value
		System.out.println(ls.stream().max((a, b)-> a>b ? a : b)); //4 similar to Integer::max; returns larger int value which is used as the comparator for 3 in relation to 4
		
		System.out.println();
		System.out.println("enthuware test 5 question 11");
		var books = new ArrayList<Book>(List.of(new Book("The Outsider", "Stephen King"),
		        new Book("Becoming", "Michelle Obama" ), new Book("Uri", "India")));
		Stream bkStrm = books.stream(); //1
//		int count = bkStrm.peek(x->x.title()).count();//2
//		int count = bkStrm.peek(x->((Book)x).title()).count();
		// signature does not include return type so even though it calls a method that returns the value is ignored
		long count = bkStrm.peek(x->((Book)x).title()).count(); 
		System.out.println("count = " + count);
		
		// From enthuware 17/21 pg 644
		// note count() and findAny() can short circuit previous intermediate operations
		System.out.println();
		System.out.println("marks");
		Stream<Integer> marks = Stream.of(55, 65, 70, 80, 70);
		System.out.println(marks.peek(System.out::println).sorted().peek(System.out::println).count()); // no change in count so short circuits peek even though sorted is stateful
		
		System.out.println("marksTwo");
		Stream<Integer> marksTwo = Stream.of(55, 65, 70, 80, 70);
		System.out.println(marksTwo.peek(System.out::println).map(i -> i.toString()).count());
		
		System.out.println("marksThree");
		Stream<Integer> marksTree = Stream.of(55, 65, 70, 80, 70);
		System.out.println(marksTree.peek(i -> System.out.print(i+" ")).toList());
		
		System.out.println("marksFour");
		Stream<Integer> marksFour = Stream.of(55, 65, 70, 80, 70);
		System.out.println(marksFour.peek(i -> System.out.print(i+" ")).max(Integer::compareTo));
		
		System.out.println("marksFive");
		Stream<Integer> marksFive = Stream.of(55, 65, 70, 80, 70);
		System.out.println(marksFive.peek(System.out::println).distinct().findAny()); // short circuits distinct even though distinct is stateful
		
		System.out.println("marksSix");
		Stream<Integer> marksSix = Stream.of(85, 65, 70, 80, 70);
		System.out.println(marksSix.peek(i -> System.out.print(i+" ")).sorted().findFirst());
		System.out.println();
		
		List<String> zero = List.of();
		var one = List.of("Bonobo");
		var two = List.of("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(m -> m.stream()).peek(System.out::println).forEach(System.out::println);
		
	}
	
	public record Book(String title, String Author) {}
}


