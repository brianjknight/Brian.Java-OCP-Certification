package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingListsInterace {
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3);

		System.out.println(nums);
		// Arrays.asList() returns a fixed size list from which you cannot add or delete elements
//		nums.add(4); // compiles but throws runtime exception. 
//		System.out.println(nums);
		nums.set(2, 4);
		System.out.println(nums);
		
		String[] words = {"one","two","three"};
		List<String> of = List.of("one","two","three");
		List<String> asList = Arrays.asList(words);
		List<String> copyOf = List.copyOf(asList);
		// List.of() return immutable list
		asList.set(0, "ten");
//		of.set(0, "four"); // runtime exception
//		copyOf.set(0, "ten"); // runtime exception
		System.out.println(asList);
		
//		var longs = new ArrayList<Long>();
		var longs = new ArrayList<>(); // omit type and default is <Object>
		longs.add("one");
		System.out.println(longs);
		longs.add(1L);
		System.out.println(longs);
		
//		for (String s : longs) System.out.println(s); // does not compile
		for (Object o : longs) System.out.println(o); 
		
		longs.replaceAll(o -> o + "!");
		System.out.println(longs);
		
		List<Integer> z = new ArrayList<>();
		z.add(2);
		z.add(4);
		z.add(2);
		z.add(4);
		z.add(6);
		z.add(8);
		z.add(10);

		System.out.println(z);
		z.remove(2); // Collections inherited remove(int index)
		System.out.println(z);
		z.add(2, 33);
		System.out.println(z);
		z.remove(Integer.valueOf(4)); // overloaded List method remove(Obj o)
		System.out.println(z);
		
		
		// List to Array
		List<Character> chars = new ArrayList<>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		
		Object[] objsArray = chars.toArray();
//		Character[] bad = chars.toArray(new Character[]);
		Character[] charArray = chars.toArray(new Character[0]);
		Character[] big = chars.toArray(new Character[10]);
		Character[] small = chars.toArray(new Character[1]);
		
		System.out.println();
		System.out.println("objArray: " + Arrays.toString(objsArray));
		System.out.println("charArray: " + Arrays.toString(charArray));
		System.out.println("big: " + Arrays.toString(big));
		System.out.println("small: " + Arrays.toString(small));
		
	}
}


