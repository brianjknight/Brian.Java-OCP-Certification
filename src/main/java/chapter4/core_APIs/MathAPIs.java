package chapter4.core_APIs;

import java.util.Random;
import java.util.*;
import java.lang.*;


public class MathAPIs {
	
	public static void main(String[] args) {
		double a = 1.8;
		Double b = 2.2;
		int c = 3;
		float d = 4.6F;
		byte e = 5;
		byte f = 6;
		
		double AA = Math.min(a, b);
		Double BB = Math.min(a, b);
//		int CC = Math.min(c, a); // does not compile. Math API uses double params to fit both types
//		byte EE = Math.max(e, f); // only return types are int, long, float, double
		int FF = Math.max(e, f);
		
		System.out.println(Math.min(a, b));
		System.out.println(Math.min(a, c));
		System.out.println(Math.max(a, 4.0F));
		System.out.println(Math.max((byte) 5, d));
		
//		int rounded = Math.round(b); //rounding a double returns a long
//		int roundPrimitive = Math.round(1.0);
		long roundDouble = Math.round(b);
		long roundFloat = Math.round(d); // rounding float returns an int
		int roundD = Math.round(d);
		
		System.out.println(Math.round(a));
		System.out.println(Math.ceil(a));
		System.out.println("Math.ceil(5.0): " + Math.ceil(5.0));
		System.out.println(Math.floor(a));
		
		Double two = 2.0;
		System.out.println(Math.pow(4, two));
		
		System.out.println(Math.random());
		System.out.println();
		
		System.out.println();
		Random r = new Random();
		System.out.println("nextInt(bound): " + r.nextInt(10));
		System.out.println("nextInt: " + r.nextInt());
		System.out.println("nextDouble: " + r.nextDouble(100.0));
		System.out.println("nextLong: " + r.nextLong());
		
	}
}
