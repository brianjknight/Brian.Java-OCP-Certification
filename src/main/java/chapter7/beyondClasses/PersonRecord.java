package chapter7.beyondClasses;

public record PersonRecord(String first, String last, int age, int weight, double height, String favortieFood) {
	
	static String species = "human";
	
	// compact constructor; no params or ()
	public PersonRecord {
		if (last == null) {
 //			this.last = "last"; // cannot modify the fields
		}
		
		if (weight <= 0) throw new IllegalArgumentException("Weigth cannot be negative!");

		first = first.toUpperCase();
	}
	
	// Overloaded cosntructor
	public PersonRecord(String first, String last) {
		this(first, last, 0, 0, 0, "pickels");
	}

	// override weight accessor
	public int weight() {
		return this.weight - 5;
	}
	
	// changes the class not the instance
	public void changeSpecies(String spec) {
		species = spec;
	}
	
}

