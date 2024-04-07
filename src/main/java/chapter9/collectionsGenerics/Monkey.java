package chapter9.collectionsGenerics;

import java.util.ArrayList;

public class Monkey extends Mammal {
	
	// valid override return type is subtype
	public ArrayList<CharSequence> play() { return new ArrayList<>(); }
	
}


