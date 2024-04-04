package chapter7.beyondClasses;

//public sealed class Snake {}
//final class Cobra extends Snake{} // declared in same file so complies

//public sealed class Snake permits Snake.Cobra { // permits optional for only a nested class extending
//public sealed class Snake permits Python { // if permits IS used, must list nested subclass
public sealed class Snake {
	
//	class Cobra extends Snake {} // BAD must declare final, sealed, or non-sealed
//	non-sealed class Cobra extends Snake {} // good
	final class Cobra extends Snake {} // declared nested subclass complies
	
}

//final class Python extends Snake {}

