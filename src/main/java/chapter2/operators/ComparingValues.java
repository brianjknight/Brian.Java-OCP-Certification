package chapter2.operators;

public class ComparingValues {
    public static void main(String[] args) {
        boolean bool = 3 < 'a';

        byte b = 1;
        long l = 2L;
        float f = 3.0F;
        char c = 'a';
        boolean byteELong = b==l;
        boolean longEfloat = l<=f;
        boolean charELong = c>=l;
//        boolean bad = b == bool;
//        boolean badNull = b==null; // primitives cannot be null
        boolean nullBool = null == null;

        String s = "1";
        Integer i = 1;
//        boolean bbb = s == i; // incompatible types
        boolean BBB = s.equals(i);
        System.out.println("BBB: " + BBB);
        
        long fivePrimitive = 5L;
        
        Number five = 5L; // autoboxed to Long object because of Number reference
        Number num = 5L; // all 3 of these are Long objects on the heap
        Object obj = 5L;

//        boolean yyy = 1 == num; // literal and Number object are not related
        boolean zzz = i == num; // comparing wrapper objects which are related
        
//        System.out.println(fivePrimitive instanceof Object);
//        System.out.println(five instanceof String); 
        System.out.println(five instanceof Long); 
        System.out.println(five instanceof Number); 
        System.out.println(five instanceof Object); 
        System.out.println();

        System.out.println(num instanceof Integer); 
        System.out.println(num instanceof Number); 
        System.out.println(num instanceof Object); 
        System.out.println();

        System.out.println(obj instanceof Integer);
        System.out.println(obj instanceof Number);
        System.out.println(obj instanceof Object);
        System.out.println();

//        boolean isString = five instanceof String;

        System.out.println("*".repeat(20));
        String abc = null;
        boolean isString = abc instanceof String;
        System.out.println(isString);
        System.out.println(null instanceof Integer);
//        System.out.println(null instanceof null); // bad
//        System.out.println(abc instanceof null); // bad
    }
}
