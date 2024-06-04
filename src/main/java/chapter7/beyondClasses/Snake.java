package chapter7.beyondClasses;

//public sealed class Snake {}
//final class Cobra extends Snake{} // declared in same file so complies

//permits optional if subclasses are nested or in same file
//if permits IS used, MUST list ALL subclasses

//public sealed class Snake { // compiles
public sealed class Snake permits Python, Snake.Cobra { // if nested AND using permits, the syntax is different
//	class Cobra extends Snake {} // BAD must declare final, sealed, or non-sealed
//	non-sealed class Cobra extends Snake {} // good
	final class Cobra extends Snake {} // declared nested subclass complies
	
}

//public sealed class Snake permits Python {} 
////public sealed class Snake {}
//
//
final class Python extends Snake {}

//non-sealed class RattleSnake {} // sealed & non-sealed must have super sealed class/interface 
