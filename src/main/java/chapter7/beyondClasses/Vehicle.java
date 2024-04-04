package chapter7.beyondClasses;

public sealed class Vehicle permits Car, Truck {
//	public sealed class Vehicle { // if a class is sealed it MUST "permit" subclasses or have nested subclass extending it
	
}
