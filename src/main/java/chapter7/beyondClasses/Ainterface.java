package chapter7.beyondClasses;

public interface Ainterface {
	default String getLetter() {
		return "A";
	}
	
	Object methodZZZ();
	
}

interface AchildInterface extends Ainterface{
	public String getLetter();
}
