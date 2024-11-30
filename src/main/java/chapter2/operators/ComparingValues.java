package chapter2.operators;

public class ComparingValues {
    public static void main(String[] args) {
    	
        Character grade = 'x';
        Character g = 'x';
        System.out.println(grade == g); // Java uses integer cache pool for values -128 to 127
        System.out.println(grade.equals(g));
        Integer oneInteger = 1;
        Integer ONE = 1;
        System.out.println(oneInteger == ONE); // true due to integer cache pool -128 to 127
        Integer big = 200;
        Integer BIG = 200;
        System.out.println(big == BIG); // false outside of cache pool
        Byte oneByte = 1;
//        System.out.println(oneInteger == oneByte); // Incompatible TYPES do not extend a hierarchy like Number > Integer
        byte bOne = 1;
        int iOne = 1;
        System.out.println("bOne == iOne: " + (bOne == iOne) ); // works with primitives integrals
        System.out.println();
        
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
        Object o = null;
        boolean nullBool = null == null;
        boolean nulll = null == o;

        String s = "1";
        Integer i = 1;
//        boolean bbb = s == i; // known incompatible types
        boolean BBB = s.equals(i); // both are Objects > uses Object equals() method which checks nulls and type relation
        System.out.println("BBB: " + BBB);
        
        long fivePrimitive = 5L;
        
        Number five = 5L; // autoboxed to Long object because of Number reference
        Number num = 5L; // all 3 of these are Long objects on the heap
        Object obj = 5L;

//        boolean yyy = 1 == num; // literal and Number object are not related
        boolean zzz = i == num; // comparing wrapper objects which are related
        
        System.out.println("instance of:");
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
