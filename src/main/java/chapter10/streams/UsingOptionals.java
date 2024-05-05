package chapter10.streams;

import java.util.Optional;

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
//		System.out.println(dubOptEmpty.orElseThrow()); // valid
		System.out.println(dubOptEmpty.orElseThrow(IllegalArgumentException::new));
		
	}
}
