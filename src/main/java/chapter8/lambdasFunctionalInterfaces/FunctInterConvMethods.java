package chapter8.lambdasFunctionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/****************************************************************************
 * <b>Title:</b> FunctInterConvMethods.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jan 16, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

public class FunctInterConvMethods {

	public static void main(String[] args) {
		
		String eggy = "eggy";
		String colorBrown = "brown";
		String colorGreen = "green";
		String colorPurple = "purple";
		
		Predicate<String> isEgg = s -> s.contains("egg"); 
		Predicate<String> notEgg = isEgg.negate();
		Predicate<String> alsoNotEgg = Predicate.not(isEgg);
		Predicate<String> isBrown = s -> s.contains("brown");
		Predicate<String> isGreen = s -> s.contains("green");
		BiPredicate<String, String> isColor = String::contains;
		
		System.out.println("is egg: " + isEgg.test(eggy));
		System.out.println("is not egg: " + notEgg.test(eggy));
		System.out.println("is brown: " + isBrown.test(colorBrown));
		System.out.println("is green: " + isGreen.test(colorGreen));
		System.out.println("is purple: " + isColor.test(colorPurple, "purple"));
		System.out.println();
		
		String eggyBrown = eggy + colorBrown;
		String eggyGreen = colorGreen.concat(eggy);
		String eggyPurple = "purple egg";
		String eggyGreenBrown = "greenish brownish egg";
		
		Predicate<String> isBrownEgg = isEgg.and(isBrown);
		Predicate<String> notBrownEgg = isEgg.and(isBrown.negate());
//		Predicate<String> isBrownOrGreenEgg = isEgg.and(isBrownEgg).or(isEgg.and(isGreen));
		Predicate<String> isBrownOrGreenEgg = isBrownEgg.or(isEgg.and(isGreen));		
//		Predicate<String> isBrownOrGreenEgg = isEgg.and(isBrown.or(isGreen));
		
		System.out.println("is brown eggyBrown: " + isBrownEgg.test(eggyBrown));
		System.out.println("not brown eggyBrown: " + notBrownEgg.test(eggyBrown));
		System.out.println("is brown eggyPurple: " + isBrownEgg.test(eggyPurple));
		System.out.println("brown or green eggyGreenBrown: " + isBrownOrGreenEgg.test(eggyGreenBrown));
		System.out.println("\"green brown chicken\" on isBrownOrGreenEgg: " + isBrownOrGreenEgg.test("green brown chicken"));
		System.out.println();
		
		Consumer<String> hi = name -> System.out.println("Hi " + name);
		Consumer<String> bye = name -> System.out.println("Bye " + name);
		Consumer<String> helloGoodbye = hi.andThen(bye);
		helloGoodbye.accept("Brian");
		System.out.println();
		
		Consumer<Integer> add5 = i -> System.out.println("num + 1 = " + (i+1));
		Consumer<Integer> add10 = i -> System.out.println("num + 100 = " + (i+100));
		Consumer<Integer> addBoth = add5.andThen(add10);
		addBoth.accept(1);  // notice the ouput is NOT 102
		System.out.println();
		
		Function<Integer, Integer> multiply2 = x -> 2 * x; 
		Function<Integer, Integer> add3 = x -> 3 + x;
		Function<Integer, Integer> multAndThenAdd = multiply2.andThen(add3); // applies input after this
		Function<Integer, Integer> multComposeAdd = multiply2.compose(add3); // applies input before this
		
		Integer n = 7;
		Integer a = multAndThenAdd.apply(n);
		Integer b = multComposeAdd.apply(n);
		System.out.println("multAndThenAdd n: " + a);
		System.out.println("multComposeAdd n:  " + b);
		
		
	}
}


