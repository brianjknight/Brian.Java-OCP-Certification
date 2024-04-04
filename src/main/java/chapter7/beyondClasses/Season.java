package chapter7.beyondClasses;

import java.util.Arrays;

public enum Season {
//	WINTER_SEASON, summer, sPrIng, Fall // valid; notice no semi-colon for simple enum
	
//	WINTER(){}, SUMMER{}, SPRING{}, FALL; // also valid
	
//	static {System.out.println("Class/Enum initialization");} // enum values MUST be first statement
	
	WINTER("Low") { // calls Season(String expectedVisitors) constructor
		public String getTemp() {
			return "-10 to 40";
		}
		@Override
		public String getHours() {
			return "10 to 4";
		}
	}, 
	SPRING("Medium") {
		public String getTemp() {
			return "20 to 70";
		}
		public String getHours() {
			return "8 to 7";
		}
	}, 
	SUMMER("High") {
		public String getTemp() {
			return "45 to 100+";
		}
	}, 
	FALL("Medium") {
		public String getTemp() {
			return "20 to 70";
		}
	}, 
	NON_SEASON("not a season") {
		public String getTemp() {
			return "unknown";
		}
	};
	
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
	static String staticField = "static field";
	private static final String constant = "c";
	
	// constructors can only be private
//	public Season() {
//		this.expectedVisitors = "Medium";
//	}
	
	// implicitly private
	Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
		System.out.println("Initializing Season Enum: " + expectedVisitors);
	}
	
	 public void printExpectedVisitors() {
		 System.out.println(expectedVisitors);
	}
	
	public static void main(String[] args) {
		System.out.println("winter toString: " + Season.WINTER);
		System.out.println("winter name: " + Season.WINTER.name());
		System.out.println("winter ordinal: " + Season.WINTER.ordinal());
		
		System.out.println("Seasons values: " + Arrays.toString(Season.values()));
		
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
		System.out.println(FALL.constant);
		System.out.println(FALL.staticField);
				
		System.out.println("summer expected visitors: " + Season.SUMMER.expectedVisitors); // access to private within Enum
		System.out.println("Winter print visitors:");
		Season.WINTER.printExpectedVisitors();
	}
}
