package chapter5.methods;

//import java.util.Arrays;
import java.util.List;

// static import example
import static java.util.Arrays.asList;
//static import java.util.Arrays.asList;

public class StaticClass {
	
	//final String greeting; // final variable must be initialized because it cannot be reassigned
	static String title;
	static String first;
	final String middle;
//	static final String last; // final must be initialized, static must be initialized in declaration or static initializer
	static final String last = "Knight";
	
	static int age;
	int addTen= 10;
//	static int ageAddTen = age + addTen; // static reference to instance variable
	
	
//	{greeting = "Good morning";}
	static {
		first = "BRIAN";
//		middle = "james"; non-static variable
	}
	static {
		age = 39;
	}
	{
		title = "Mr";
	}
	
	StaticClass() {
		first = "Brian";
		middle = "James";
//		last = "knight";
		final String nothing; // final local variable only needs initialized before it is used
	}
	
	static String getFullName() {
		// static String midInitial = "J"; only final modifier is allowed inside a method

		// static members can only call other static members directly. 
		// Instance members must referenced by an instance of the class e.g. sc.middle
		StaticClass sc = new StaticClass();
		return first + sc.middle + last;
	}
	
	// instance member can call static members
	String getFirstLast() {
		String full = StaticClass.getFullName(); // call to static method
		String FULL = getFullName();
		return first + last; // using static variables
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1,2,3};

		
		// Not you can import a class and a static method and call it both ways.
		List<Integer> ints = asList(nums);
//		List<Integer> list = Arrays.asList(nums); // trickery but be sure BOTH are imported

		System.out.println(StaticClass.title);
		System.out.println(StaticClass.first);
		System.out.println(StaticClass.last);
		
		StaticClass sc = new StaticClass();
		System.out.println(sc.first);
		System.out.println(sc.middle);
		System.out.println(sc.last);
	}
}
