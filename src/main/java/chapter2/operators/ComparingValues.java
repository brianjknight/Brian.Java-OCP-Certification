package chapter2.operators;

public class ComparingValues {
    public static void main(String[] args) {
        boolean intChar = 3 < 'a';

        byte b = 1;
        long l = 2L;
        float f = 3.0F;
        char c = 'a';
        boolean byteELong = b==l;
        boolean longEfloat = l==f;
        boolean charELong = c==l;
//        boolean bad = b == bEL;
//        boolean badNull = b==null; // primitives cannot be null
        
        Number five = 5L;
        Number num = five;
        Object obj = five;

        System.out.println(five instanceof Long); // true
        System.out.println(five instanceof Number); // true
        System.out.println(five instanceof Object); // true

        System.out.println(num instanceof Integer); // false; object on heap is a Long
        System.out.println(num instanceof Number); // true
        System.out.println(num instanceof Object); // true

        System.out.println(obj instanceof Integer);
        System.out.println(obj instanceof Number);
        System.out.println(obj instanceof Object);

//        boolean isString = five instanceof String;

        System.out.println("*".repeat(20));
        String abc = null;
        boolean isString = abc instanceof String;
        System.out.println(isString);
        System.out.println(null instanceof Integer);
//        System.out.println(null instanceof null); 
//        System.out.println(abc instanceof null); 
    }
}
