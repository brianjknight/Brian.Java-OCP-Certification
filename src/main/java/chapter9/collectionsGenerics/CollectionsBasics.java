package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionsBasics {
	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<>();
//		Collection<> bad = new ArrayList<String>();
		
		System.out.println("s.add(\"a\"): " + coll.add("a")); 
		coll.add("b");
		coll.add("a");
		coll.add("c");
		coll.add("b");
		coll.add("a");
		coll.add("c");
		
		coll.forEach(System.out::print);
		
		System.out.println();
		System.out.println(coll.remove("a")); // removes SINGLE first element
		System.out.println(coll);
		System.out.println("******");
		System.out.println(coll.removeAll(List.of("a")));
		System.out.println(coll);
		System.out.println(coll.remove("a"));
		System.out.println(coll.removeIf(x -> x.equals("b")));
		System.out.println(coll);
		coll.clear();
		System.out.println(coll);
		
	}
}


