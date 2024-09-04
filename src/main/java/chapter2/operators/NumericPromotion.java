package chapter2.operators;

public class NumericPromotion {

    public static void main(String[] args) {
    	
        
        char A = 'A';
        int x = 1000;
        System.out.println(A + x);

        long a = 1000;
        long b = 3_000_000_000_000_000L;

        int y = 5;
        System.out.println("y=" + y);
        int z = (y=3);
        System.out.println("y=" + y);
        System.out.println("z=" + z);
        int q = y=1;
        System.out.println("y=" + y);
        System.out.println("q=" + q);


        float f = 10L;

        byte one = 1;
        byte negOne = -1;
        byte okOne = --one;
        byte xOne = one;
//        byte badOne = -one; // variable used Java assumes int type 
        
        byte num = 1 + 2; // literals are considered int by default BUT can fit into byte 
//        byte four = num + 1; // when variable is present, operands are ALWAYS promoted to int
        					// Java doesn't know at compile type if 'num' value fits into byte primitive
//        byte four = (byte) num + 1; // even when casting, a binary operator and variable are used 
        								// so after cast numeric promotion happens
//        byte four = (byte) num + (byte) 1; // still bad
        
        
        final int intFinal = 1;
        final long longFinal = 1;
        byte weird = -intFinal + 1; // oneFinal is a known compile time constant since it is FINAL; type promotion to ints but fits in byte
//        byte noGood = longFinal + 1; // type promotion to long so not allowed
        final Byte b1 = 1;
//        Byte b2 = -b1; //will not compile even though b1 is final and wrappers are immutable;
        // above the reference is final not the underlying object/value 
        // different than final byte primitive above
        
        byte two = ++one; // unary and compound operators are exceptions to rule and implicitly cast
        byte three = 0;
        three += two + 1;
        
        byte five = 2 + (int) 3; // int but literal fits in byte
        int ten = five + 5; // variable so byte five is promoted to int
        
        byte i = 126 + 1;
//        byte j = 100 + 100; // both are int literals; result 200 int literal cannot fit into byte
//        byte k = 200 + 100; // both are int literals; no numeric promotion > result 300 does not fit into byte
        
     // numeric promotion due to VALUES of different primitive
//        int k = 1 + 1L;  
        long l = 1 + 1L;
        int m = 'a' + 1; // char literal value promoted to int
        byte n = 'a' + 1; // promotion but result fits in a byte
        char o = 97;
//        int oo = 97;
//        char oooo = oo;  // bad variable oo is now and assumed to be default int type
        System.out.println("char o = 97; is " + o);
        
        
        float abc = 2.0F;
        float def = 1 + abc;
        
        Integer fifteen = 15;
        Integer twenty = 20;
        System.out.println(fifteen + twenty);
        System.out.println();
        
        boolean aa = false;
        boolean bb = false;
        boolean cc = false;
        // Associative grouping happens prior to left to right evaluation of operators
        // && takes precedence over ||
        // associatively grouped
        // the operating left to right short circuits before bb and cc are assigned
        // therefore bool becomes (aa = true) || (  (bb = true) && (cc = true)  )
        boolean bool = (aa = true) || (bb = true) && (cc = true) ;
//        boolean bool = (aa = true) | (bb = true) && (cc = true) ; // compare to not short circuiting
        System.out.println(aa + ", " + bb + ", "+ cc );
    }
    
    void test() {
    	byte b = 1;
//    	b = b<<1;
    	int c = b<<1;
//    	byte d += b;
    	byte e = 0;
    	e += b;
    }
}
