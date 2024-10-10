package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class BoundingWithWildcard<T> {

	public static void main(String[] args) {
		
		BoundingWithWildcard<String> bww = new BoundingWithWildcard<>();
		
		// bounding with wildcard
		
		List<?> a = new ArrayList<String>(); // unbounded list
//		a.add("abc"); // wildcard bound types become immutable
//		a.add(new Object());
		a.add(null);
//		List<?> b = new ArrayList<?>(); // instantiated object must set a type
//		List<E extends Number> genericList; // does not compile
//		List<T extends Number> genericFromClassList; // does not compile
		List<? extends Number> wildList;
		
		List<Object> objectList = new ArrayList<>();
//			List<Object> oList = new ArrayList<String>(); // not allowed but you can add Strings to the an Object List
		List<?> oooList = new ArrayList<String>(); // not allowed instantiate actual object with wildcard ?
		List<String> stringList = new ArrayList<>();
		bww.addToList(objectList);
//		bww.addToList(stringList); // cannot pass a List<String> when expecting a List<Object>
		bww.addToLowerBoundList(objectList);
		bww.addToLowerBoundList(stringList);
		
		ArrayList<Mammal> mams = new ArrayList<>();
		mams.add(new Mammal());
		mams.add(new Mammal());
		
		List<? extends Mammal> mammals = mams;
		List<? extends Mammal> goats = new ArrayList<Goat>();
		List<? extends Mammal> goatBabby = new ArrayList<GoatBabby>();
//		List<? extends Mammal> objs = new ArrayList<Object>(); // does not compile breaks upper bound Mammal
		
//		mammals.add(new Mammal()); // upper bound & unbound list become immutable
		mammals.add(null);
		
		List<? super Goat> goatList = new ArrayList<Goat>();
		List<? super Goat> mammalList = new ArrayList<Mammal>();
		List<? super Goat> objList = new ArrayList<Object>();
//		List<? super Goat> goatBabby = new ArrayList<GoatBabby>(); //does not compile GoatBabby breaks lower bound
//		goatList.add(new Mammal()); // does not compile
//		mammalList.add(new Mammal());
		mammalList.add(new Goat());
//		mammalList.add(new Mammal()); // has to do with not having a upper bound on parent; however class of goat or subtype will always fit in the list 
		goatList.add(new Goat());
		goatList.add(new GoatBabby());
			
		List<String> colors = List.of("red","green","blue");
		List<Integer> nums = List.of(1,2,3); 
		
		System.out.println("printGeneric():");
		bww.printGeneric(colors);
		bww.printGeneric(nums);
		System.out.println("<T>printGeneric()");
		bww.<String>printGeneric(colors);
//		bww.<String>printGeneric(nums); // does not compile
		
		System.out.println();
		System.out.println("printWildcard:");
		bww.<String>printWildcard(colors);  
		bww.printWildcard(nums);
		
		bww.print("Hello");
		bww.<String>print("World"); // not sure why Java would allow this but it compiles
//		bww.<Integer>print("World");
		bww.<Integer>print(1);
		
	}
	
	// generic type requires formal param <T> declaration
	public <T> void printGeneric(List<T> list) { // example of generic method type <T> independent of class generic type
		for (Object o : list) { 
			System.out.println(o);
		}
	}
	
	
	public void printWildcard(List<?> list) { // wildcard does NOT require declaration of formal type <?>
		for (Object o : list) { 
			System.out.println(o);
		}
	}
	
	public <S> void print(S s) {
		System.out.println(s);
	}
//	public <Q> void print(Q extends Number) { // cannot mix generic with bounding
//		System.out.println(s);
//	}
	
	public void addToList(List<Object> list) {
		list.add("a string");
	}
	
	public void addToLowerBoundList(List<? super String> list) {
		list.add("a string");
	}
	
	public <X extends Number & Comparable & Runnable> void multiBound() {
//		List<? extends Number & Comparable & Runnable> multiUpperBoundedList = null;
		
	}
}



