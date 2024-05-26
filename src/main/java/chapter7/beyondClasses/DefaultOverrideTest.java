package chapter7.beyondClasses;

public class DefaultOverrideTest implements Walk, Run {
	public int getSpeed() {return 1;}
	
	public int getWalkSpeed() {
//		return super.getSpeed(); // super is Object type
		return Walk.super.getSpeed();
	}
}


interface Walk {
	public default int getSpeed() { return 5; }
}

interface Run {
	public default int getSpeed() { return 10; }
}

