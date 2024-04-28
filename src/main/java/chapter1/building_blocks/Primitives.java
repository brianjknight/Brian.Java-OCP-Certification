package chapter1.building_blocks;

public class Primitives {
    public static float code;

    public static void main(String   []
                                    args)
    {
        System.out.println(code);
        System.out.println(Primitives.code);
        System.out.println(0 + "_");
        System.out.println(0 + '_');

        Primitives p = new Primitives();
        System.out.println(p.n);
        System.out.println(Math.max((double) 2.0,2.0f));

        
        Double d = 1357999.2468;
        System.out.println(d.byteValue());
    }

    String n; // variables can use letters, numbers, currency symbol, and underscore
    String _n;
    String $n;
    String €n;
    String ¥n;
//    String 2n; // bad
//    String _; // bad
//    String n$%; // bad

    int hex = 0xa3f;
    int octal = 015;
//    int notOctal = 0185;
    int binary = 0b0101;
    
    byte b = 127;
    short s = 32767;
    int i =       2_147_483_647;
    long little = 2_147_483_647;
    // Because Java defaults integer literals to int type, there is no loss of data when storing little Long as a long.
    // However, bigLong requires postfix L to designate it as a long.
//    long doesNotCompile = 2_147_483_648;
    // Note casting to long does not compile. This is due to type promotion.
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
    int one = Integer.valueOf("1");
    Integer two = Integer.valueOf("2");
    // 3 becomes int primitive but is then autoboxed to Integer
    Integer three = Integer.parseInt("3");

    byte bTwo = two.byteValue();
    short sTwo = two. shortValue();
    int iTwo = two.intValue();
    int iiTwo = (int) two;
    int iiiTwo = two;
    long lTwo = two.longValue();

    int maxA = Math.max(one, two);
    int maxB = Math.max(i, (int) d);


}
