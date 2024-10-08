package chapter5.methods;

import java.util.Arrays;
import java.util.List;

// static import example
import static java.util.Arrays.*; // wild card allowed for static imports
import static java.util.Arrays.asList; // redundant but shows single static import
//static import java.util.Arrays.asList;

public class StaticClass {
	
//	final String greeting; // final variable must be initialized
	static String title;
	static String first;
	final String middle;
//	static final String last; // final must be initialized, static must be initialized in declaration or static initializer
	static final String last = "Knight";
	
	static int age;
	int addTen= 10;
//	static int ageAddTen = age + addTen; // static reference to instance variable
	int ageAddTen = age + addTen;
	
//	{greeting = "Good morning";}
	static {
		first = "BRIAN";
//		this.first = "BRIAN"; // "this" keyword CANNOT be used in a static context
//		middle = "james"; // non-static variable
	}
	static {
		age = 39;
	}
	{
		title = "Mr"; // instance initializer on class variable is allowed. note title is not final
	}
	
	StaticClass() {
		first = "Brian"; // ALL instances now have first name of Brian
		middle = "James";
//		last = "knight";
		final String nothing; // final local variable only needs initialized before it is used
//		nothing = " ";
//		nothing = "";
	}
	
//	StaticClass(String middle) { // with multiple constructors need to account for initializing final fields
//		// final String middle is initialized in no args constructor but not here
//	}
	
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

		
		// Note if you import a class AND a static method, you can call it both ways.
		List<Integer> ints = asList(nums);
		List<Integer> list = Arrays.asList(nums); // trickery > be sure BOTH are imported
		Integer[] copy = copyOf(nums,3);
		
		System.out.println(StaticClass.title);
		System.out.println(StaticClass.first);
		System.out.println(StaticClass.last);
		System.out.println();
		
		StaticClass sc = new StaticClass();
		System.out.println(sc.title);
		System.out.println(sc.first);
		System.out.println(sc.middle);
		System.out.println(sc.last);
		System.out.println();
		
		System.out.println(StaticClass.getFullName());
		System.out.println();
		
		StaticClass scNull = null;
		System.out.println("scNull.first: " + scNull.first);
	}
}
