package chapter8.lambdasFunctionalInterfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacePractice {
	
	public static void main(String[] args) {
		
		Supplier<LocalDate> s1 = LocalDate::now;
		System.out.println("Supplier s1: " + s1);
		LocalDate d1 = s1.get();
//		LocalDate d2 = LocalDate::now; // only allowed where a lambda can be used as a Functional interface
		System.out.println("date: " + d1);
		
		Supplier<ArrayList<String>> s2 = () -> new ArrayList<>();
		List<String> strList = s2.get();
//		List<Integer> intList = s2.get();
		System.out.println("list: " + strList);
		
		Consumer<String> c1 = System.out::println;
		c1.accept("Hello Brian");
		
		BiConsumer<String, Integer> bc1 = (var a, var b) -> System.out.println("Day: " + a + " date: " + b);
		bc1.accept("Sunday",14);
		
//		BiConsumer<Integer, Double> bIntDoub = (a,b) -> a+b; 
		
		Map<String,Integer> map = new HashMap<>();
		BiConsumer<String, Integer> bc2 = map::put;
		BiConsumer<String, Integer> bc3 = (t,u) -> map.put(t, u);
		bc2.accept("Brian", 39);
		bc3.accept("Allison", 42);
		System.out.println(map);
		
		Predicate<String> p1 = x -> x.isEmpty();
		System.out.println("empty string: " + p1.test("not empty"));
		
		BiPredicate<String, String> bp1 = String::startsWith;
		System.out.println("starts with: " + bp1.test("Brian", "B"));
		
		
		Function<Integer, Double> f1 = Integer::doubleValue;
		System.out.println("double value: " + f1.apply(10));
		
		BiFunction<Double, Double, Integer> bf1 = Double::compareTo; // returns neg, 0, or pos int
		System.out.println("1 compare 2: " + bf1.apply(1.0, 2.0));
		
		BiFunction<String,String,String> bf2 = String::concat;
		System.out.println(bf2.apply("hello ", "world"));
		
		UnaryOperator<String> uo1 = String::toUpperCase;
		System.out.println("caps: " + uo1.apply("hello"));
		
//		BinaryOperator<Double> bo1 = Double::compareTo; // return of compareTo int is incompatible with <Double,Double,Double>
		BinaryOperator<String> b02 = (a,b) -> a.concat(b);
		BinaryOperator<String> b03 = String::concat;
		System.out.println("greeting: " + b02.apply(uo1.apply("hello"), uo1.apply(" world")));
		
		DifParamTypes dpt = (String a, Integer b) -> System.out.println(a + " " + b);
		dpt.print("i am", 39);
	}
	
}

@FunctionalInterface
interface DifParamTypes {
	void print(String s, Integer i);
}

