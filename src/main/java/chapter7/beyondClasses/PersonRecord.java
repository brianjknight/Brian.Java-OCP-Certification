package chapter7.beyondClasses;

// implicitly and ONLY allowed to be public & final
// can implement interfaces
// cannot use extend
public record PersonRecord(String first, String last, int age, int weight, double height, String favortieFood) {
	
	static String species;
	static {
		species = "human";
	}
//	private final String insField = "instance field"; // new instance fields are not allowed
//	{System.out.println("instance initializer");} // instance initializers also not allowed
	
	// implicit all arg constructor but can implement 
	// allows you to set instance fields
//	public PersonRecord(String first, String last, int age, int weight, double height, String favortieFood) {
//		this.first = first;
//		this.last = last;
//		this.age = age;
//		this.weight = weight;
//		this.height = height;
//		this.favortieFood = favortieFood;
//	}
	
	// special compact constructor; no params or ()
	// acts as the all args constructor when called new PersonRecord(, , , , , )
	public PersonRecord {
		if (last == null) {
			// this.last = "last"; // cannot modify the fields directly in compact constructor 
			// it calls long implicit long constructor 
		}
		
		if (weight < 0) throw new IllegalArgumentException("Weigth cannot be negative!");

		// allowed because first is the constructor param not the instance field
		first = first.toUpperCase();
//		this.first = first.toUpperCase(); // not allowed
		
		// the long constructor is implicitly called at the end of compact constructor with the modified parameters
	}
	
	
	// Overloaded constructor
	public PersonRecord(String first, String last) {
//		first = first.toUpperCase();
		this(first, last, 0, 0, 0, "pickles"); // constructed with this therefore next line has no affect on the object
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
	
	// changes the class not the instance
	public void changeSpecies(String spec) {
		species = spec;
	}
	
}

