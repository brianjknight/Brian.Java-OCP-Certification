package chapter6.classDesign;

import java.io.FileNotFoundException;
import java.util.List;

public class Parent {
	private Number age = 40;
	final String name = "Brian";
	static int staticNum = 99;
	private String secret = "parent's secret";
	String misc = "misc";
	
	// default no args constructor inserted by compiler
	
	protected Number getAge() throws FileNotFoundException, 
									 IndexOutOfBoundsException {
		return age;
	}
	public String getSecret() {return secret;};
	public void setSecret(String secret) {this.secret = secret;};
	
	// if made public, getSize() in Child no longer compiles
	// return type of int is not a covariant of String and also reduces accessibility
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
		System.out.println("parent get to work");
	}
	
	static void doStaticWork() {
		System.out.println("parent do static work");
	}
	
	static void hiddenStatic() {
		System.out.println("Parent hiddenStatic()");
	}
	
	public void sayGoodBye() {
		System.out.println("good bye from parent");
	}
	
	public List<String> hairy(List<String> list){
		return null;
	}
}
