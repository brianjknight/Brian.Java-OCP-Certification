package chapter10.streams;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class UsingPrimitiveStreams {
	
	public static void main(String[] args) {
		
		IntSummaryStatistics iss = IntStream.rangeClosed(2,4).summaryStatistics();
		System.out.println(iss);
		System.out.println("count: " + iss.getCount());
		System.out.println("avg: " + iss.getAverage());
		System.out.println(LongStream.of().summaryStatistics());
		System.out.println();
		
		DoubleStream dStream = DoubleStream.of(1.5,2.5,3.5);
		
		var doubling = LongStream.iterate(1, n -> n*2);
		doubling.limit(10).forEach(System.out::println);
		System.out.println();
		
		List<Double> randomDoubles = new ArrayList<>();
		DoubleStream ds = DoubleStream.generate(Math::random);
		ds.limit(4).forEach(randomDoubles::add);
		System.out.println(randomDoubles);
		System.out.println();
		
		IntStream fiveRandInts = new Random().ints().limit(5); // not on exam?
		fiveRandInts.forEach(System.out::println);
		System.out.println();
		
		System.out.println("odds between 0-10 " + IntStream.range(0,10)
														   .boxed()  // boxed() is necessary to use Stream.collect(Collector);
														   .collect( Collectors.filtering(i -> i%2!=0, Collectors.toList()) ) 
						   									);  
		// primitives have .collect() but takes 3 params but not a single collector 
		
		System.out.println();
		IntStream.rangeClosed(1,5).forEach(System.out::print);
		System.out.println("\n");
		
		
		DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
		List<String> doubleStringList = doubleStream.mapToObj(String::valueOf).toList();
//		IntStream intStream = doubleStream.mapToInt(d -> (int) d); // valid; careful this stream was already closed
//		LongStream longStream = doubleStream.mapToLong(d -> (long) d); // valid
//		DoubleStream backToDoubleStream = intStream.mapToDouble(i -> i); // valid
		
		System.out.println("doubleStringList: " + doubleStringList);
		
		// primitive to Ojb stream
		Stream<Integer> intStr1 = IntStream.of(1,2,3).mapToObj(x -> x);
		Stream<Integer> intStr2 = IntStream.of(1,2,3).boxed();
		Stream<Integer> intStr3 = LongStream.of(1,2,3).mapToObj(x -> (int) x);
//		Stream<Integer> intStr4 = IntStream.of(1,2,3).mapToObj(Function.identity()); // not an IntToObj function
		
		OptionalDouble optD = IntStream.rangeClosed(0,10).average();
		System.out.println("optD average: " + optD.orElse(0.0));
//		System.out.println(optD.get()); // get() not available for primitive Optionals
		System.out.println("optD average again: " + optD.getAsDouble());
		System.out.println();
		
		List<List<Integer>> integerList = new ArrayList<>();
		integerList.add(List.of(1, 2, 3));
        integerList.add(List.of(4, 5, 6));
        integerList.add(List.of(7, 8, 9));
        // mapToDouble for each nested list then flatMapToDouble to flatten the 3 lists
		DoubleStream doublesFromInts = integerList.stream().flatMapToDouble(list -> list.stream().mapToDouble(i -> i)); // mapToDouble(ToDoubleFunctin<T>) unboxes Integer fits in double
		List<Double> doubleStreamList = doublesFromInts.boxed().toList(); // boxed returns Stream<Double>
//		List<Double> otherDoublesList = doublesFromInts.mapToObj(d -> d).toList(); //also works
		System.out.println("doubleStreamList: " + doubleStreamList);
		
		
//		OptionalDouble optDouble = Optional.empty(); // does not compile Optional.empty() returns Optional<T> not OptionalDboule
		OptionalDouble optDouble = OptionalDouble.empty();
//		Double d = optDouble.get(); // does not compile
		Double d = optDouble.getAsDouble();
		
		
		var ls = LongStream.of(1,2,3); // remember these are primitives not Long wrapper so Java can implicitly cast and not need to autobox
//		Stream<Long> longSream = Stream.of(1,2,3); // this does not compile
	}
	
}


