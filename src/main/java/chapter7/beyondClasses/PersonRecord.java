package chapter7.beyondClasses;

import java.io.Serializable;

record EmptyRecord() {} // allowed to compile

// can implement interfaces
// cannot use extend but implicitly extends java.lang.Record
// implicitly and ONLY allowed to be public & final
public final record PersonRecord(String first, String last, int age, int weight, double height, String favortieFood) implements Serializable{
	
	public static String species;
	static {
		species = "human";
	}
//	private final String insField = "instance field"; // new instance fields are not allowed
//	{System.out.println("instance initializer");} // instance initializers also not allowed
	
	// implicit all arg constructor but can implement 
	// allows you to set instance fields
//	public PersonRecord(String first, String last, int age, int weight, double height, String favortieFood) {
//		this.first = first.toUpperCase();
//		this.last = last == null ? "n/a" : last;
//		this.age = age;
//		if (weight < 0) throw new IllegalArgumentException("Weigth cannot be negative!"); // RuntimeException allowed
//		this.weight = weight;
//		this.height = height;
//		this.favortieFood = favortieFood;
//	}
	
	// special compact constructor; no params or ()
	// acts as the all args constructor when called new PersonRecord(, , , , , ); CANNOT have both all args and compact
	public PersonRecord { // canonical constructor cannot use throws
		if (last == null) {
//			 this.last = "n/a"; // cannot modify the fields directly in compact constructor 
		}
		
		if (weight < 0) throw new IllegalArgumentException("Weigth cannot be negative!");

		// allowed because first is the constructor param not the instance field
		first = first.toUpperCase();
//		this.first = first.toUpperCase(); // not allowed
		
		// compiler implicitly assigns values to instance fields
	}
	
	
	// Overloaded constructor
	public PersonRecord(String first, String last) throws Exception {
//		first = first.toUpperCase();
		this(first, last, 0, 0, 0, "pickles"); // MUST call this(...); constructed with this therefore next line has no affect on the object
		first = "" + first.substring(0,2).toLowerCase() + first.substring(2).toUpperCase(); // validation check
		System.out.println(first); // param was changed however the instance was already created with this() call
	}

	// override weight accessor
	@Override // optional annotation
	public int weight() {
		return this.weight - 5;
	}
	
	public void setWeight() {
//		this.weight -= 5; // weight is final		
	}
	
	public int getWeight() {
		int weight = this.weight; // allowed to access this fields
		System.out.println("not default accessor");
		return weight;
	}
	
	// changes the class not the instance
	public void changeSpecies(String spec) {
		species = spec;
	}
	
}

