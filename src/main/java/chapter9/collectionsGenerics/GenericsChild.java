package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericsChild extends Generics {

//	public List<CharSequence> getter() {return null;} // compiles but redundant override
	
//	public ArrayList<CharSequence> getter() {return null;} // compiles

	// according to the book generic param must match exactly to compile
	// why does this work? 
	@Override
	public List<String> play() {return new ArrayList<>();}
	
	// Double is a subtype of object not an interface
//	public void doNothing(List<Double> in) {} // same type erasure as parent method
	
}


