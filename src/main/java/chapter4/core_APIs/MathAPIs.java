package chapter4.core_APIs;

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
		long roundDouble = Math.round(b);
		long roundFloat = Math.round(d); // rounding float returns an int
		int roundD = Math.round(d);
		
		System.out.println(Math.round(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		
		Double two = 2.0;
		System.out.println(Math.pow(4, two));
	}
}
