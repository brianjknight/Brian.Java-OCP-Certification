package chapter7.beyondClasses;

//import static chapter7.beyondClasses.Season.*;

public class EnumTest {
	
	public static void main(String[] args) {
		
		Season s = Season.FALL;
		
		System.out.println(s);
//		System.out.println(FALL); // does not compile without a static import
		
		switch (s) {
			case FALL:
				System.out.println("it's Fall");
				break;
	//		case Season.FALL: // does not compile
				
			default:
				break;
			}
		
//		Season a = new Season(); // cannot create instance of Enum objects. treat as a static class
		
	}
}
