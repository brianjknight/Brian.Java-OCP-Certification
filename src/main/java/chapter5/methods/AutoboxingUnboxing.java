package chapter5.methods;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
        // Java will not autobox and implicit cast at the same time.
        // Long a = 8; 
        Long b = 8L;
        long c = 8; // int literal 8 needs to be implicitly cast to a long widening type

        Short five = 5; // Java knows int literal 5 can fit in the narrowing type short
        short FIVE = 5;
        
        // however, Java can unbox and implicit cast at the same time

        Integer d = 8;
        long e = d; // unboxing Integer to int, implicit cast int to long


        // Example of explicitly casting instead of letting Java autobox & unbox
        Character h = Character.valueOf('Z');
        char i = h.charValue();

        // be careful with null values when autoboxing/unboxing is happening
        Character f = null;
        char g = f; // throws NullPointerException. Behind the scenes Java is trying to call method on a null object

        AutoboxingUnboxing auto = new AutoboxingUnboxing();
        // Java will not autobox arrays
        // auto.makeArray(new int[] {1,2,3}); // does not compile


    }

    public void makeArray(Integer[] nums) {}
}
