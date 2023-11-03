package chapter6.classDesign;

public class Parent {
	private Number age = 40;
	
	protected Number getAge() {
		return age;
	}
	
	// if made public, getSize() in Child no longer compiles
	// return type of int is not a covariant of String
	private String getSize() {
		return "10";
	}
	
	public static String greeting() {
		return "Hello";
	}
	
	public final boolean isCitizen() {
		return true;
	}
	
}
