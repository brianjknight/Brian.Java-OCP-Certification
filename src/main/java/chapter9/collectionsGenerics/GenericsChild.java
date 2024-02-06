package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> GenericsChild.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jan 31, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

public class GenericsChild extends Generics {

//	public List<CharSequence> getter() {return null;} // compiles but redundant override
	
//	public ArrayList<CharSequence> getter() {return null;} // compiles

	// according to the book generic param must match exactly to compile
	// why does this work? 
	public List<String> play() {return new ArrayList<>();}
	
	// Double is a subtype of object not an interface
//	public void doNothing(List<Double> in) {} // same type erasure as parent method
	
}


