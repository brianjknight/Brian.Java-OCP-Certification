package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsingListsInterface {
	public static void main(String[] args) {
		
//		List<String> strList = List.of("a", null); // runtime NullPointer exception; factory methods .of() & .copyOf() do not allow null values
		ArrayList<String> a1;
//		ArrayList<> a2; // compiler has no way to infer the type parameter
		ArrayList a3;
//		Integer iValue1 = ListProcessor.processList(new ArrayList<>()); //Integer inferred (ListProcessor example class from book pg 442)
		
		// enthuware OCP 17 test 1 question 9
		String[] sa = { "charlie", "bob", "andy", "dave" };
		List<String> saList = Arrays.asList(sa);
//	    var ls = new ArrayList<String>(Arrays.asList(sa));
	    var ls = Arrays.asList(sa); // returns a list BACKED BY the array. Changes to the array affect the list.
	    List<String> strList = List.of(sa);
	    var coll = Collections.unmodifiableList(ls); // unmodifiable VIEW backed by given collection
	    sa[2] = "alex";
	    ls.sort((var a, var b) -> a.compareTo(b));
	    System.out.println(sa[0]+" "+ls.get(0));
	    
	    System.out.println("List.of(sa): " + strList); // List.of(), List.copyOf() are NOT backed by the array ie do not reflect changes
	    saList.set(0, "Austin");
	    System.out.println("Coll.unmodifiableList: " + coll);
	    System.out.println();
		
		List<String> empty = new ArrayList<String>(3);
		System.out.println(empty);
		System.out.println(empty.size());
		System.out.println("*********************");
		System.out.println();
		
		List<Integer> nums = Arrays.asList(1,2,3);
		List<Integer> numsAgain = Arrays.asList(1,2,3);
		ArrayList<Integer> arrList = new ArrayList<>(nums);
		Set<Integer> numsSet = new HashSet<>(nums);
		System.out.println(nums.indexOf(new Exception())); // compiles and NO exception param of different type; signature isS indexOf(Object o)
		System.out.println(nums.contains("three"));
		System.out.println(nums);
		System.out.println("nums.equals(numsAgain): " + nums.equals(numsAgain)); // overridden equals for Collections compartes type, contents, & order
		System.out.println("nums == numsAgain: " + (nums == numsAgain));
		System.out.println("arrList.equals(nums): " + arrList.equals(nums));
		System.out.println("numsSet.equlas(nums): " + numsSet.equals(nums));
		// Arrays.asList() returns a fixed size list from which you cannot add or delete elements
//		nums.add(4); // compiles but throws runtime exception. 
		nums.set(2, 4);
		System.out.println(nums);
		
		System.out.println("*********************");
		System.out.println();
		
		String[] words = {"ONE","two","three"};
		List<String> asList = Arrays.asList(words);
		List<String> of = List.of("ONE","two","three");
		List<String> ofA = List.of(words); // compiles signature of(E... elements) also accepts a single Array
		System.out.println("asList: " + asList);
		System.out.println("ofA: " + ofA);
		List<List<String>> ofB = List.of(of, ofA); // complies .of with collection
		List<String> copyOf = List.copyOf(asList);
		// List.of() return immutable list
		asList.set(0, "ten");
//		of.set(0, "four"); // runtime exception
//		copyOf.set(0, "ten"); // runtime exception
//		Collections.sort(ofA); // immutable collection List.of(...)
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
		z.add(null);
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
//		char [] castPrimArray = (char[]) castWrapperArray; // not allowed
//		char[] toPrimiive = chars.toArray(new char[0]);
//		Character[] bad = chars.toArray(new Character[]); // requires size
//		Character[] bad = chars.toArray(); // BAD toArray() no params returns Object[]
//		Character[] negativeArray = chars.toArray(new Character[-1]); // runtime Exception
		Character[] charArray = chars.toArray(new Character[0]);
		Character[] big = chars.toArray(new Character[10]);
		Character[] small = chars.toArray(new Character[1]);
		
		System.out.println("objArray: " + Arrays.toString(objsArray));
		System.out.println("charArray: " + Arrays.toString(charArray));
		System.out.println("big: " + Arrays.toString(big));
		System.out.println("small: " + Arrays.toString(small));
		
		List<Integer> moreInts = new ArrayList<>();
		moreInts.add(10);
//		moreInts.add(3, 11); // index out of bounds
		System.out.println();
		System.out.println(moreInts);
		
		
		Integer[] cast = {1};
//		int[] casted = (int[]) cast; // does not compile
		
		System.out.println();
		
		// sublist is backed by the original list
		System.out.println("OCP Java 17/21 book pg. 452");
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList( new String[]{"a", "b", "c", "d", "e" } ));
		List<String> sublist = list.subList(2, 4);
		System.out.println(sublist); //prints [c, d]
		sublist.add("x");
		System.out.println(sublist); //prints [c, d, x]
		System.out.println(list); //prints [a, b, c, d, x, e]
		list.add("y"); //structural modification to the original list invalidates the existing sublist
		System.out.println(sublist); //throws java.util.ConcurrentModificationException trying to print invalidated sublist
		
	}

}


