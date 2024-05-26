package chapter7.beyondClasses;

import java.util.Arrays;

public enum Season implements EnumInterface { // allowed to implement interfaces
//	WINTER_SEASON, summer, sPrIng, Fall // valid; notice no semi-colon for simple enum
	
//	WINTER(){ void winterMethod() {} }, SUMMER{}, SPRING{}, FALL // also valid

//	WINTER(){}, SUMMER{}, SPRING{}, FALL // requires semi-colon because of methodA 
//	void methodA() {};
	
//	static {System.out.println("Class/Enum initialization");} // enum values MUST be first statement
	
	WINTER("Low") { // calls Season(String expectedVisitors) constructor
		public String getTemp() {
			return "-10 to 40";
		}
		@Override
		public String getHours() {
			return "10 to 4";
		}
		public void sayHello() {} // abstract interface methods must be implemented by every enum value
	}, 
	SPRING("Medium") {
		public String getTemp() {
			return "20 to 70";
		}
		public String getHours() {
			return "8 to 7";
		}
		public void sayHello() {}
	}, 
	SUMMER("High") {
		public String getTemp() {
			return "45 to 100+";
		}
		public void sayHello() {}
	}, 
	FALL("Medium") {
		public String getTemp() {
			return "20 to 70";
		}
		public void sayHello() {}
	}, 
	NON_SEASON("not a season") {
		public String getTemp() {
			return "unknown";
		}
		public void sayHello() {}
	}; // semi-colon required to mark end of ENUM declarations
	
	// requires all enums values to implement the abstract method
	public abstract String getTemp();
	
	// method can be overridden in value implementation
	public String getHours() {
		return "9 to 5";
	}
	
	static {
		System.out.println("Class/Enum initialization");
	}
	
	private final String expectedVisitors; 
	public static String staticField = "static field";
	private static final String CONSTANT = "c";
	
	// constructors can only be private
//	public Season() {
//		this.expectedVisitors = "Medium";
//	}
	
	// implicitly private AND only private
//	public Season(String expectedVisitors) {
	Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
		System.out.println("Initializing Season Enum: " + expectedVisitors);
	}
	
	 public void printExpectedVisitors() {
		 System.out.println(expectedVisitors);
	}
	
	public static void main(String[] args) {
		System.out.println(WINTER == WINTER);
		System.out.println(WINTER.equals(WINTER));
		System.out.println();
		
		System.out.println("winter toString: " + Season.WINTER);
		System.out.println("winter name: " + Season.WINTER.name());
		System.out.println("winter ordinal: " + Season.WINTER.ordinal());
		
		Season[] seasonValues = Season.values(); 
		System.out.println("Seasons values: " + Arrays.toString(seasonValues));
		
		Season summer = Season.valueOf("SUMMER");
		System.out.println("summer: " + summer);
		
		Season s = Season.valueOf("SPRING");
//		Seasons s = Seasons.valueOf("spring"); // runtime IllegalArgumentException due to case
		
		switch(s) {
//			case Seasons.SUMMER : // does not compile
			case SUMMER: 
				System.out.println("it's summer");
				break;
			case SPRING: 
				System.out.println("it's spring");
				break;
					
		}
		
		System.out.println(FALL);
		System.out.println(Season.FALL);
		System.out.println(Season.FALL.getHours());
		System.out.println(FALL.getTemp());
		System.out.println(FALL.expectedVisitors);
		System.out.println(FALL.CONSTANT);
		System.out.println(FALL.staticField);
				
		System.out.println("summer expected visitors: " + Season.SUMMER.expectedVisitors); // access to private within Enum
		System.out.println("Winter print visitors:");
		Season.WINTER.printExpectedVisitors();
	}
}
