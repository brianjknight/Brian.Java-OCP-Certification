package chapter5.methods;

import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class StaticClass {
	
	//final String greeting; // final instance variables must be initialized because it COULD be used
	static String title;
	static String first;
	final String middle;
	static final String last = "Knight";
	
	//{greeting = "Good morning";}
	static {
		first = "BRIAN";
	}
	
	StaticClass() {
		first = "Brian";
		middle = "James";
		// last = "knight";
		final String nothing; // final local variable only needs initialized before it is used
	}
	
	static String getName() {
		//static String midInitial = "J"; only final modifier is allowed inside a method
		return first + last;
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1,2,3};

		
		// Not you can import a class and a static method and call it both ways.
		List<Integer> ints = asList(nums);
		List<Integer> list = Arrays.asList(nums);

//		System.out.println(StaticClass.title);
		System.out.println(StaticClass.first);
		System.out.println(StaticClass.last);
		
		StaticClass sc = new StaticClass();
		System.out.println(sc.first);
		System.out.println(sc.middle);
		System.out.println(sc.last);
	}
}
