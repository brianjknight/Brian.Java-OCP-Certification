package chapter7.beyondClasses;

public interface Binterface {
	default String getLetter() {
		return "B";
	}
	
	CharSequence methodZZZ();
}
