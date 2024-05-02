package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class UsingListsInterface {
	public static void main(String[] args) {
		
		List<String> empty = new ArrayList<String>(3);
		System.out.println(empty);
		System.out.println(empty.size());
		System.out.println("*********************");
		System.out.println();
		
		List<Integer> nums = Arrays.asList(1,2,3);
		List<Integer> numsAgain = Arrays.asList(1,2,3);
		System.out.println(nums.indexOf("three")); // compiles and NO exception param of different type; signature -> indexOf(Object o)
		System.out.println(nums.contains("three"));
		System.out.println(nums);
		System.out.println("nums.equals(numsAgain): " + nums.equals(numsAgain)); // overridden equals for Collections compartes type, contents, & order
		System.out.println("nums == numsAgain: " + (nums == numsAgain));
		// Arrays.asList() returns a fixed size list from which you cannot add or delete elements
//		nums.add(4); // compiles but throws runtime exception. 
		
		nums.set(2, 4);
		System.out.println(nums);
		
		System.out.println("*********************");
		System.out.println();
		
		String[] words = {"ONE","two","three"};
		List<String> asList = Arrays.asList(words);
		List<String> of = List.of("ONE","two","three");
		List<String> ofA = List.of(words); // compiles
		System.out.println("asList: " + asList);
		System.out.println("ofA: " + ofA);
		List<List<String>> ofB = List.of(of, ofA); // complies .of with collection
		List<String> copyOf = List.copyOf(asList);
		// List.of() return immutable list
		asList.set(0, "ten");
//		of.set(0, "four"); // runtime exception
//		copyOf.set(0, "ten"); // runtime exception
		System.out.println(asList);
		System.out.println("*********************");
		System.out.println();
		
//		var long = new ArrayList<Long>(); // ref type ArrayList of Long
		var longs = new ArrayList<>(); // omit type and default is ArrayList<Object>
		longs.add("ONE");
		System.out.println(longs);
		longs.add(1L);
		System.out.println(longs);
		
//		for (String s : longs) System.out.println(s); // does not compile
//		for (String (String) s : longs) System.out.println(s); // does not allow casting and will not compile
//		for (Object s : longs) {
//			System.out.println((String) s); // compiles but throws class exception on the Long
//		}
		System.out.println("print string instances:");
		for (Object s : longs) if (s instanceof String str) System.out.println(str); 
		System.out.println("print objects:");
		for (Object o : longs) System.out.println(o); 
		
		longs.replaceAll(o -> o + "!");
		System.out.println("print string instances:");
		for (Object s : longs) if (s instanceof String str) System.out.println(str); 
		System.out.println("*********************");
		System.out.println();
		
		List<Integer> z = new ArrayList<>();
		z.add(2);
		z.add(4);
		z.add(2);
		z.add(4);
		z.add(6);
		z.add(8);
		z.add(10);

		System.out.println(z);
		z.remove(2); // overloaded List remove(int index); remember Java uses the exact signature first (int) vs (Object)
		System.out.println(z);
		z.add(2, 33);
		System.out.println(z);
		z.remove(Integer.valueOf(4)); //  Collections inherited method remove(Obj o)
		System.out.println(z);
		System.out.println("*********************");
		System.out.println();
		
		// List to Array
		List<Character> chars = new ArrayList<>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		
		Object[] objsArray = chars.toArray(); // default is a new Object array
//		Character[] castWrapperArray = (Character[]) objsArray ; // runtime exception > it is an Obj[] on the heap
//		char [] castPrimArray = (char[]) castWrapperArray; // no allowed
//		Character[] bad = chars.toArray(new Character[]); // requires size
//		Character[] bad = chars.toArray(); // BAD toArray() no params returns Object[]
		Character[] charArray = chars.toArray(new Character[-1]);
		Character[] big = chars.toArray(new Character[10]);
		Character[] small = chars.toArray(new Character[1]);
		
		System.out.println("objArray: " + Arrays.toString(objsArray));
		System.out.println("charArray: " + Arrays.toString(charArray));
		System.out.println("big: " + Arrays.toString(big));
		System.out.println("small: " + Arrays.toString(small));
		
		List<Integer> moreInts = new ArrayList<>();
		moreInts.add(10);
//		moreInts.add(15, 2); // index out of bounds
		System.out.println();
		System.out.println(moreInts);
		
		
//		Integer[] cast = {1};
//		int[] casted = (int[]) cast; // does not compile
	}
}


