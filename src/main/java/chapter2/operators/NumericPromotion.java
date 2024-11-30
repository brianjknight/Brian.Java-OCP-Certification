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
        byte okOne = --one; // increment/decrement operators implicitly casts like compound assignment
        byte xOne = one;
//        byte badOne = -one; // variable with unary operator Java promotes to int 
        long oneLong = 1L;
//        byte longByte = oneLong;
        
        byte num = 1 + 2; // literals are considered int by default BUT can fit into byte 
//        byte four = num + 1; // when variable is present, operands are ALWAYS promoted to int
        					// Java doesn't know at compile type if 'num' value fits into byte primitive
//        byte four = (byte) num + 1; // order of operations is cast then binary operator to type promotion occurs
//        byte four = (byte) num + (byte) 1; // still bad
        
        
        final int intFinal = 1;
        final long longFinal = 1;
        byte weird = -intFinal + 1; // intFinal is a known compile time constant since it is FINAL; type promotion to int but fits in byte
//        byte noGood = -longFinal + 1; // type promotion to long so not allowed
        final Byte b1 = 1;
//        Byte b2 = -b1; //will not compile even though b1 is final and wrappers are immutable;
        // above the reference is final not the underlying object/value 
        // different than final byte primitive above
        
        final byte _21 = 21;
        final char _12 = 12;
        char _33 = _21 + _12; // binary operator numeric promotion to int, BUT compile time constants and result fits into char
        byte _3_3 = _21 + _12;
        System.out.println("final char _12: " + _12);
        System.out.println("char _33 = " + _33); 
        System.out.println("byte _3_3 = " + _3_3);
        System.out.println(_12 + _21); 
        
        byte two = ++one; // increment/decrement and compound operators are exceptions to rule and implicitly cast
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
        int oo = 97;
//        char oooo = oo;  // bad variable oo is a wider primitive int and requires explicit cast 
        System.out.println("char o = 97; is " + o);
        
        
        float abc = 2.0F;
        float def = 1 + abc;
        
        Integer fifteen = 15;
        Integer twenty = 20;
        System.out.println(fifteen + twenty); // unboxing for binary operator
        System.out.println();
        
        boolean aa = false;
        boolean bb = false;
        boolean cc = false;
        // Associative grouping happens prior to left to right evaluation of operators
        // && takes precedence over ||
        // associatively grouped
        // the operating left to right short circuits before bb and cc are assigned
        // therefore bool below becomes (aa = true) || (  (bb = true) && (cc = true)  )
        boolean bool = (aa = true) || (bb = true) && (cc = true) ;
//        boolean bool = (aa = true) | (bb = true) && (cc = true) ; // logical operator does not short circuit
        System.out.println(aa + ", " + bb + ", "+ cc );
    }
    
    void test() {
    	byte b = 1;
//    	b = b<<1;
    	int c = b<<1;
//    	byte d += b; // d has not been instantiated yet
    	byte e = 0;
    	e += b;
    }
}
