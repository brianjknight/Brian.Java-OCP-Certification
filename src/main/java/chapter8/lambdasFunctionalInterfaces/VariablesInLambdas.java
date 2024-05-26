package chapter8.lambdasFunctionalInterfaces;

import java.util.function.*;

public class VariablesInLambdas {
	public static void main(String[] args) {
		
		Supplier<String> bc = () -> "hi";
		
		BiPredicate<String, String> bp1 = (x, y) -> true;
		BiPredicate<String, Integer> bp1_2 = (x, y) -> true;
//		Bipredicate<String, String> bp1_3 = (String x, y) -> true; // cannot mix declared and inferred types
		BiPredicate<String, String> bp2 = (var x, var y) -> true;
		BiPredicate<String, String> bp3 = (String x, String y) -> true;
		BiPredicate<String, Integer> bp4 = (String x, Integer y) -> true;
//		BiPredicate<String, Integer> bp5 = (String x, var y) -> true; // cannot mix var with other types
		
		BinaryOperator<Integer> bo = (a,b) -> {
//			int a = 1; // a already declared
			int c = 0; 
			return 5;};
		
	}
	
	static String greet = "hello";
	private String color;
	public void caw(String name) {
		String volume = "loudly";
//		String s;
//		name = "crow";
		color = "black";
		
		Consumer<String> consumer = s -> 
				System.out.println(
						s +							// lambda variable
						greet +						// static/class variable
						name + " says "  			// method param - must be final/effectively final
						+ volume + " that she is "  // local variable - must be final/effectively final
						+ color);					// instance/member variable always accessible
				
//		volume = "softly";
		color = "red"; // instance variable does NOT need to be effectively final
				
		consumer.accept("xxx");
	}
	
}


