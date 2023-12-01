package chapter6.classDesign;

import java.io.FileNotFoundException;

public class Parent {
	private Number age = 40;
	final String name = "Brian";
	
	protected Number getAge() throws FileNotFoundException, IndexOutOfBoundsException {
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
	
	public void doWork() {
		System.out.println("get to work");
	}
	
	public void sayGoodBye() {
		System.out.println("good bye from parent");
	}
}
