package chapter2.operators;

public class ComplementOperators {
    public static void main(String[] args) {
        // ~ bitwise complement only works on integral primitive types

        int five = 5;
        int fiveComplement = ~five; // variables cannot be known at compile time but works because default is int
        int fiveComplementComplement =     ~      fiveComplement;
        System.out.println(five);
        System.out.println(fiveComplement);
        System.out.println(fiveComplementComplement);

        double ten = 10.0;
//        double doubleCompDoesNotCompile = ~ten; // bitwsie operator only allowed on integer types

        char a = 'a';
//        char aComplementDoesNotCompile = ~a; // does not compile > returns an int not char
        int aComplementDoesCompile = ~a;
        char aCharComplement = (char) ~a;
        System.out.println("print a: " + a);
        System.out.println(a);
        System.out.println(0 + a);
        System.out.println(1 + 'a');
        System.out.println(1 + a);
        System.out.println("print ~a: " + ~a);
        System.out.println("aCharComplement: " + aCharComplement);
        System.out.println("ascii test (char) 10_000: " + (char) 10_000);
        System.out.print("'a' + 'b': ");
        System.out.println('a' + 'b');

        byte two = 2;
        // below does not compile because java assumes the number literal of two to be an int
        // bitwise operator works on an int but remains an int
        // then needs to be cast to a byte type
//        byte bad = ~two; // two variable is a byte, however Java uses promotion for variables 
//        byte bad = -two;
//        byte badAgain = ~( (byte) two ); // TWO IS A VARIABLE
        byte twoComplement = (byte) two; // therefore need to cast ~two
        byte again = ~2; // 2 IS A LITERAL, for literals Java will use assignment type
        byte xxx = ~(byte)2; // unnecessary
        byte twoComplementComplement = (byte) ~twoComplement;
        System.out.println(two);
        System.out.println(twoComplement);
        System.out.println(twoComplementComplement);

    }
}
