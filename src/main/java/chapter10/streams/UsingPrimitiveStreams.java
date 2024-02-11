package chapter10.streams;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
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
		System.out.println(IntStream.of(new int[] {}).summaryStatistics());
		System.out.println();
		
		DoubleStream dStream = DoubleStream.of(1.5,2.5,3.5);
		
		var doubling = LongStream.iterate(1, n -> n*2);
//		doubling.limit(50).forEach(System.out::println);
		
		List<Double> randomInts = new ArrayList<>();
		DoubleStream ds = DoubleStream.generate(Math::random);
		ds.limit(4).forEach(randomInts::add);
		System.out.println(randomInts);
		
		System.out.println();
//		IntStream fiveRandInts = new Random().ints().limit(5); // not on exam
//		fiveRandInts.forEach(System.out::println);
		System.out.println("odds between 0-10 " + IntStream.range(0,10)
														   .boxed()  // boxed() is necessary to use Stream.collect(Collector);
														   .collect(Collectors.filtering(i -> i%2!=0, Collectors.toList())));  
		// primitives have .collect() but takes 3 params but not a single collector
		
		System.out.println();
		IntStream.rangeClosed(1,5).forEach(System.out::print);
		System.out.println();
		
		DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
		List<String> doubleList = doubleStream.mapToObj(String::valueOf).toList();
		System.out.println("doubleList: " + doubleList);
		
		// primitive to Ojb stream
		Stream<Integer> intStr1 = IntStream.of(1,2,3).mapToObj(x -> x);
		Stream<Integer> intStr2 = IntStream.of(1,2,3).boxed();
		Stream<Integer> intStr3 = LongStream.of(1,2,3).mapToObj(x -> (int) (x / 2.0) );
		
		OptionalDouble optD = IntStream.rangeClosed(0,10).average();
		System.out.println("optD average: " + optD.orElse(0.0));
		
		
		
	}
	
}


