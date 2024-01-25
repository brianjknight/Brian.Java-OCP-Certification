package chapter8.lambdasFunctionalInterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctInterPrimitives {
	public static void main(String[] args) {
		
		DoubleSupplier dsTwo = () -> 2.0;
		System.out.println("dsTwo: " + dsTwo.getAsDouble());
		
		DoubleSupplier dsRandom = Math::random;
		
		System.out.println("dsRand: " + dsRandom); // be careful on output shown that the interface method is called
		System.out.println("dsRand: " + dsRandom.getAsDouble());
		System.out.println("rand: " + Math.random());
//		System.out.println(Math::random); using a method reference must be accepted as a functional interface
		
		LongPredicate lpIsEven = d -> d % 2 == 0;
		System.out.println("lpIseven: " + lpIsEven.test(9L));
		
		IntBinaryOperator intBOsum = (x,y) -> x+y;
		System.out.println("intBoSum: " + intBOsum.applyAsInt(5, 3));
		
		DoubleBinaryOperator dBoMultiply = (a,b) -> a*b;
		System.out.println("dBoMultiply: " + dBoMultiply.applyAsDouble(2L, 1.5));
		
		ToDoubleFunction<String> tdf = Double::parseDouble;
		System.out.println("tdf: " + tdf.applyAsDouble("5.556"));
		ToDoubleFunction<String> toDoubleFunc = s -> Double.parseDouble(s);
		System.out.println("toDoubleFunc: " + toDoubleFunc.applyAsDouble("1.32"));
		
		Map<String, Integer> map = new HashMap<>();
		ObjIntConsumer<String> putInMap = (s, d) -> map.put(s, d);
		ObjIntConsumer<String> putObjIntConsumer = map::put;
		putInMap.accept("a", 1234);
		putObjIntConsumer.accept("b", 4567);
		System.out.println("map: " + map);
	}
}
