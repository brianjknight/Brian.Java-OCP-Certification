package chapter2.operators;

public class ComplementOperators {
    public static void main(String[] args) {
        // ~ bitwise complement only works on integral primitive types

        int five = 5;
        int fiveComplement = ~five;
        int fiveComplementComplement =     ~      fiveComplement;
        System.out.println(five);
        System.out.println(fiveComplement);
        System.out.println(fiveComplementComplement);

        double ten = 10.0;
//        double doubleCompDoesNotCompile = ~ten;

        char a = 'a';
        // does not compile because java assume an int value for char in order to perform bitwise complement
//        char aComplementDoesNotCompile = ~a;
        char aComplement = (char) ~a;
        System.out.println("a:" + a);
        System.out.print("print ~a");
        System.out.println(~a);
        System.out.println(aComplement);
        System.out.println('a' + 'b');

        byte two = 2;
        // below does not compile because java assumes the number literal of two to be an int
        // bitwise operator works on an int but remains an int
        // then needs to be cast to a byte type
//        byte twoComplementDoesNotCompile = ~two;
        byte twoComplement = (byte) ~two;
        byte twoComplementComplement = (byte) ~twoComplement;
        System.out.println(two);
        System.out.println(twoComplement);
        System.out.println(twoComplementComplement);

    }
}
