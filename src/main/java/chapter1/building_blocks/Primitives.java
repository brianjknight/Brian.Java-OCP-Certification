package chapter1.building_blocks;

public class Primitives {
    public static float code;

    public static void main(String   []
                                    args)
    {
        System.out.println(code);
        System.out.println(Primitives.code);
        System.out.println(0 + "_");
        System.out.println(0 + '_'); // promote char to int then adds

        Primitives p = new Primitives();
        System.out.println(Math.max((double) 2.0,2.0f));

        
        Double d = 1357999.2468;
        System.out.println(d.byteValue());
        
        
        System.out.println(10 / 2 * 4);
        System.out.println(10 * 2 / 4);
        System.out.println();
        
        Double zero = 0.0;
        System.out.println(-1.0/zero); // divide by zero with floating point primitive or type does not throw exception
        System.out.println(1.0/zero);
        System.out.println(0.0/0.0); // Nan
        
        System.out.println();
        p.testMethod();
        
        System.out.println();
        p.testIntFormat();
    }

    int hex = 0xa3f;
    int octal = 0105;
//    int notOctal = 0108; // octals have 0 prefix with values 0-7
    int extraZeros = 000;  // valid but an octal
    int binary = 0b0101;
    
    byte b = 127;
    short s = 32767;
    int i =       2_147_483_647;
    long little = 2_147_483_647;
    // Because Java defaults integer literals to int type, there is no loss of data when storing little Long as a long.
    // However, bigLong requires postfix L to designate it as a long.
//    long doesNotCompile = 2_147_483_648;
    // The value is first interpreted as an int by the compiler and is out of range
//    long doesNotCompileAgain = (long) 2_147_483_648;
    long big = 2_147_483_648L;

    float f = 123.45F;
    double d = 123.45;


    float four = 4;
//    float fourA = 4.0;
    float fourB = 4.0F;
    float fourC = 4.0f;
    float another4;

    void floatFourFloat() {
        another4 = 4;
        another4 = (float) 4;
        another4 = (float) 4F;
//        another4 = 4.0;
    }


//    int nullValue = null;

    int zero = Integer.parseInt("0");
    int one = Integer.valueOf("1");  // return wrapper then unboxes to primitive
    Integer two = Integer.valueOf("2");
    // 3 becomes int primitive but is then autoboxed to Integer
    Integer three = Integer.parseInt("3");
//    Double badDouble = Integer.parseInt("1"); // autobox & implicit cast to a large type
    
    byte bTwo = two.byteValue();
    short sTwo = two. shortValue();
    int iTwo = two.intValue();
    int iiTwo = (int) two;
    int iiiTwo = two;
    long lTwo = two.longValue();

    double dTwo = two; // unboxed and implicitly cast to widening double primitive
//    Double Dtwo = two; // requires unboxing two Integer to int; but cannot cast & autobox double > Double
//    byte b2b = two; // Java cannot unbox and implicitly cast to narrowing type at same time
//    byte b2b2 = (byte) two; // attempt to explicitly cast prevents unboxing
    byte bbbTwo = (byte) (int) two;
    
    
    int maxA = Math.max(one, two);
    int maxB = Math.max(i, (int) d);

    void testMethod() {
    	Long l = 1L;
    	l += 1;
    	l++;
    	System.out.println("testMethod l=" + l);
    }
    
    void testIntFormat() {
    	int i = 10_00;
    	String s = "10_00"; // bad format for parsing string
    	
//    	Integer x = Integer.parseInt(s);
//    	Integer y = Integer.valueOf(s);
    	int z = Integer.valueOf(i);
//    	int X = Integer.parseInt("0b0101"); // cannot parse binary
//    	int Y = Integer.parseInt("1.017"); // bad format for int
    	Double d = Double.parseDouble("-.0017");  // allowed
    	System.out.println(d);
    }
}
