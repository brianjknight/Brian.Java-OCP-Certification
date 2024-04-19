package chapter5.methods;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
        // Java will not autobox and implicit cast smaller primitive to larger at the same time.
//        Long a = 8; 
        Long b = 8L;
        long c = 8; // int literal 8 needs to be implicitly cast to a long widening type
        Long xx = -c;
        int yy = 8;
//        Long yyyy = yy;
        
        Short five = 5; // Java knows the larger int literal 5 can fit in the narrowing type short and does not need to implicitly cast.
        // so only autoboxing occurs above for Short five = 5;
        short FIVE = 5;
//        Short anotherFive = -five; // variable with operator is promoted to int
        
//        Byte tooBig = 500; // cannot convert int to Byte cast and autobox required since 500 literal cannot fit into byte
        
        // however, Java can unbox and implicit cast at the same time

        Integer d = 8;
        long e = d; // unboxing Integer to int, implicit cast int to long


        // Example of explicitly casting instead of letting Java autobox & unbox
        Character h = Character.valueOf('Z');
        char i = h.charValue();

        Character y = 'y';
        char Y = y;
        
        // be careful with null values when autoboxing/unboxing is happening
        Character f = null;
        char g = f; // throws NullPointerException. Behind the scenes Java is trying to call method f.charValue() on a null object

        AutoboxingUnboxing auto = new AutoboxingUnboxing();
        // Java will not autobox arrays
        // auto.makeArray(new int[] {1,2,3}); // does not compile


    }

    public void makeArray(Integer[] nums) {}
}
