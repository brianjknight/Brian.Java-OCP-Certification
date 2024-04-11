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
//        byte badOne = -one; // java cannot know one type at compile time so assumes MUST be an int
        
        byte num = 1 + 2; // literals are considered int by default BUT can fit into byte 
//        byte four = num + 1; // when variable is present, operands are ALWAYS promoted to int
        					// Java doesn't know at compile type if 'num' value fits into byte primitive
        byte five = 2 + (int) 3; // int but literal fits in byte
        int ten = five + 5; // variable so byte five is promoted to int
        
        byte i = 126 + 1;
//        byte j = 100 + 100; // both are int literals; result 200 int literal cannot fit into byte
//        byte k = 200 + 100; // both are int literals; no numeric promotion > result 300 does not fit into byte
        
     // numeric promotion due to VALUES of different primitive
//        int k = 1 + 1L;  
        long l = 1 + 1L;
        int m = 'a' + 1; // char promoted to int
        
        
    }
}
