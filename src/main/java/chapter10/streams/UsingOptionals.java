package chapter10.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class UsingOptionals {
	public static void main(String[] args) {
		Optional<Double> dubOptEmpty = Optional.empty();
		Optional<Double> dubOpt = Optional.of(2.0);
		
		if (dubOpt.isPresent()) {
			System.out.println(dubOpt.get());
		}
		dubOpt.ifPresent(System.out::println);
		System.out.println(dubOpt.orElseGet(() -> Math.random()));
		System.out.println(dubOpt.orElseThrow());
		
//		System.out.println(dubOptEmpty.orElse("double")); // must return parameterized type
//		System.out.println(dubOpt.orElseGet(() -> new Exception())); // must return parameterized type
		System.out.println(dubOptEmpty.orElseGet(Math::random));
		
		
		Stream<String> wolf = Stream.of("w","o","l","f!");
		// (a, b) -> a+b is a combiner which combines results of threads IF accumulator runs concurrently
		int length = wolf.reduce(0, (i, s) ->	i+s.length(), (a, b) -> a+b);
		System.out.println("length: " + length);
	
		
	}
}
